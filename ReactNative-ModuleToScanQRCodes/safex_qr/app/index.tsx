import React, { useState, useEffect } from 'react';
import { StyleSheet, TouchableOpacity, Alert, View } from 'react-native';
import { Text } from '@/components/Themed';
import { CameraView, useCameraPermissions } from 'expo-camera/next';
import axios from 'axios';

export default function SafexQRScanner() {
  const [facing, setFacing] = useState('back');
  const [permission, requestPermission] = useCameraPermissions();
  const [isScanning, setIsScanning] = useState(false);
  const [entryRecorded, setEntryRecorded] = useState(false);
  const sheetAPI = "https://sheet.best/api/sheets/b24adc9c-7402-468c-8eb5-ac1d26afaf7b";

  useEffect(() => {
    (async () => {
      await requestPermission();
    })();
  }, []);

  const handleBarcodeScanned = async ({ data }) => {
    if (!isScanning) return;
    setIsScanning(false);
  
    const now = new Date();
    const fecha = `${now.getFullYear()}-${(now.getMonth() + 1).toString().padStart(2, '0')}-${now.getDate().toString().padStart(2, '0')}`;
    const hora = now.getHours();
    const minutos = now.getMinutes().toString().padStart(2, '0');
  
    try {
      // Consultar todos los registros del día
      const response = await axios.get(sheetAPI);
      const registrosDelDia = response.data;
      console.log(registrosDelDia)
  
      // Filtrar los registros para encontrar los que coinciden con el ID del alumno
      const registrosAlumno = registrosDelDia.filter(registro => registro.Fecha === fecha && registro.ID === data);
  
      let registro = { Fecha: fecha, ID: data, Registro: '', Hora: `${hora}:${minutos}` };
      let mensajeAlerta = '';
  
      // Lógica para determinar si se registra una entrada o salida
      if ((hora >= 7 && hora < 9) || registrosAlumno.length === 0) {
        registro.Registro = 'E'; // Entrada
        mensajeAlerta = `ID alumno: ${data}\nEntrada registrada correctamente\nHora: ${hora}:${minutos}`;
      } else {
        const entradaExistente = registrosAlumno.some(reg => reg.Registro === 'E');
        if (entradaExistente) {
          const ultimoRegistro = registrosAlumno[registrosAlumno.length-1];
          if(ultimoRegistro.Registro === 'S') {
            registro.Registro = 'E'; // Entrada fuera de tiempo
            mensajeAlerta = `ID alumno: ${data}\nEntrada fuera de tiempo registrada correctamente\nHora: ${hora}:${minutos}`;
          }else {
            registro.Registro = 'S'; // Salida
            mensajeAlerta = `ID alumno: ${data}\nSalida registrada correctamente\nHora: ${hora}:${minutos}`;
          }
        } else {
          registro.Registro = 'E'; // Entrada fuera de tiempo
          mensajeAlerta = `ID alumno: ${data}\nEntrada fuera de tiempo registrada correctamente\nHora: ${hora}:${minutos}`;
        }
      }
  
      // Enviar el nuevo registro al spreadsheet
      await axios.post(sheetAPI, registro);

      Alert.alert('Código QR Escaneado', mensajeAlerta, [{ text: 'OK', onPress: () => setIsScanning(true) }], { cancelable: false });
    } catch (error) {
      console.error("Error al interactuar con la hoja de cálculo", error);
      Alert.alert('Error', 'Ocurrió un error al procesar el escaneo. Intente nuevamente.', [{ text: 'OK' }]);
    }
  };
  

  const handleScanPress = () => {
    setIsScanning(true);
  };

  if (!permission) {
    return <View style={styles.container}><Text>Solicitando permisos...</Text></View>;
  }

  if (!permission.granted) {
    return <View style={styles.container}><Text>Se necesitan permisos para la cámara</Text></View>;
  }

  return (
    <View style={styles.container}>
      {!isScanning && (
        <TouchableOpacity style={styles.scanButton} onPress={handleScanPress}>
          <Text style={styles.scanButtonText}>Escanear QR</Text>
        </TouchableOpacity>
      )}
      {isScanning && (
        <CameraView
          style={styles.camera}
          facing={facing}
          onBarcodeScanned={handleBarcodeScanned}
          barCodeScannerSettings={{
            barCodeTypes: ['qr'],
          }}
        />
      )}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'black',
    justifyContent: 'center',
    alignItems: 'center',
  },
  camera: {
    flex: 1,
    width: '100%',
  },
  scanButton: {
    backgroundColor: 'blue',
    padding: 15,
    borderRadius: 5,
    marginBottom: 20,
  },
  scanButtonText: {
    color: 'white',
    fontSize: 18,
    fontWeight: 'bold',
  },
  buttonContainer: {
    position: 'absolute',
    bottom: 20,
    left: 20,
  },
  button: {
    backgroundColor: 'white',
    padding: 10,
    borderRadius: 5,
  },
  text: {
    fontSize: 16,
  },
});