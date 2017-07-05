Watchdog MT Android Application
Proactive Sensing
Robert Douglass

All files programmed and created by me are located in...
	\WatchdogMT\app\src\main\java\com\sentrytechnologies\bobbydouglass\watchdogmt\...
	\WatchdogMT\app\src\main\res\layout\...
	\WatchdogMT\app\src\main\AndroidManifest.xml

To install the application and test it out, install this file to your android device...
	\WatchdogMT\app-release.apk

Notes:
	All application features should be working properly, however they have not been thoroughly
	tested as they were recently implemented.

Menu:
	Read Status
		This screen has two modes.  The first mode, Modbus mode, reads a raw string
		through NFC from the Watchdog device.  The second mode, Debug mode, reads back data sent
		through NFC from the other features in the app.
	
	Make Local Input Changes
		This screen allows the user to modify five options for the eight local inputs to program to
		the Watchdog MT over NFC.  Options include the local input mode, recognition time,
		the name of the local input device, the pulse multiplier, and the text for units of
		measure.  Please note that one of the local input modes must be set to "3 = Pulse Counter"
		in order to program and access the last two options.  If the user makes any changes and
		presses the back button, the app will prompt the user asking if they want to save the
		changes made, or to discard.  If the user chooses to save the changes, the app will
		redirect to the NFC screen where it will guide you through sending the data over NFC.
		Once the user sends the changes over nfc, the app saves the changes to the phone,
		so that the user can come back to the changes they made later on even if the phone is
		restarted.

	Make Modbus Changes
		This screen allows the user to modify 9 options for the 24 Modbus devices connected to
		the Watchdog MT.  Options include Modbus ID, Modbus command, register address, register data
		format, alarm configuration, calibration, low and high limits, Modbus name, text for units of
		measure.  This screen acts the same as the Make Local Input Screen, where it will prompt the
		user and redirecting to the NFC screen, thus saving the changes made.