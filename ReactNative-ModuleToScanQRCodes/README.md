
# React Native School Entry/Exit Tracking Module

## Overview
This repository contains a specialized module developed as part of a larger React Native application, aimed at enhancing security and management within educational settings. The primary function of this module is to facilitate the tracking of student drop-offs and pickups by parents or guardians through QR code scanning. Each QR code contains a unique student ID, which, when scanned, registers the entry or exit event along with the time and date in a Google Spreadsheet.

**Note**: This module is a contribution to a broader project developed by a team. The version presented here is the portion I am authorized to share, focusing on the QR scanning functionality for student attendance tracking.

## Technical Implementation
The module's logic includes:
- Fetching daily records from the Google Spreadsheet to identify previous entries or exits for each student.
- Filtering records to match the scanned QR code's student ID with the corresponding database entry.
- Implementing a time-based logic to categorize the scan as an entry or exit, including handling late entries.
- Posting the new record back to the spreadsheet for centralized data storage.

An `axios` library is used for HTTP requests to interact with the Google Spreadsheet, and the `Alert` component from React Native provides immediate feedback to the user upon scanning.

## Challenges and Solutions
- Ensuring accurate entry/exit categorization required careful consideration of various scenarios, such as late entries and re-entries within the same day.
- Integration with Google Spreadsheet as a backend solution presented a unique approach to utilizing common tools for specialized applications.

## Features

### 1. Main View with Scan Button
- The initial interface presents a straightforward layout with a prominent button to initiate the QR scanning process.

![Main View with Scan Button](https://github.com/AlonsoSOscarI/Portfolio/blob/main/ReactNative-ModuleToScanQRCodes/Outputs-ReactNative/1.%20Main%20view%20with%20button%20to%20scan.jpeg)

### 2. QR Scanning Using the Mobile's Camera
- Utilizes the mobile device's camera within the app to scan QR codes, providing a seamless and efficient way to log entries and exits.

![Scanning QR Using the Mobile's Camera in App](https://github.com/AlonsoSOscarI/Portfolio/blob/main/ReactNative-ModuleToScanQRCodes/Outputs-ReactNative/2.%20Scannin%20QR%20using%20the%20mobile's%20camera%20in%20app.jpeg)

### 3. Alert with Scanned QR Info
- Immediately after scanning, the app displays an alert showing crucial information from the QR code, such as the student ID, the time of the scan, and whether it's marked as an entry or exit.

![Alert with the Scanned QR Info](https://github.com/AlonsoSOscarI/Portfolio/blob/main/ReactNative-ModuleToScanQRCodes/Outputs-ReactNative/3.%20Alert%20with%20the%20scanned%20QR%20info.jpeg)

### 4. Spreadsheet Basic Settings in Sheet.best
- Configuration details of the Google Spreadsheet are managed through Sheet.best, which transforms the spreadsheet into a REST API endpoint, showcasing the backend setup that supports this system.

![Spreadsheet Basic Settings in Sheet.best](https://github.com/AlonsoSOscarI/Portfolio/blob/main/ReactNative-ModuleToScanQRCodes/Outputs-ReactNative/4.%20Spreadsheet%20basic%20settings%20in%20sheetbest.png)

### 5. The Spreadsheet
- The final data storage and visualization occur in a Google Spreadsheet, where each record is neatly organized, displaying all the entries and exits, complete with timestamps and student IDs.

![The Spreadsheet](https://github.com/AlonsoSOscarI/Portfolio/blob/main/ReactNative-ModuleToScanQRCodes/Outputs-ReactNative/5.%20Spreadsheet.png)

## Conclusion
This module represents a focused effort to leverage mobile and cloud technologies for improving the operational aspects of educational institutions, showcasing the potential for innovative solutions in everyday challenges.

## License
This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.
