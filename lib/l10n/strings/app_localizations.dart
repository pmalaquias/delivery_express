
import 'dart:async';

import 'package:flutter/foundation.dart';
import 'package:flutter/widgets.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:intl/intl.dart' as intl;

import 'app_localizations_en.dart';
import 'app_localizations_es.dart';
import 'app_localizations_pt.dart';

/// Callers can lookup localized strings with an instance of AppLocalizations returned
/// by `AppLocalizations.of(context)`.
///
/// Applications need to include `AppLocalizations.delegate()` in their app's
/// localizationDelegates list, and the locales they support in the app's
/// supportedLocales list. For example:
///
/// ```
/// import 'strings/app_localizations.dart';
///
/// return MaterialApp(
///   localizationsDelegates: AppLocalizations.localizationsDelegates,
///   supportedLocales: AppLocalizations.supportedLocales,
///   home: MyApplicationHome(),
/// );
/// ```
///
/// ## Update pubspec.yaml
///
/// Please make sure to update your pubspec.yaml to include the following
/// packages:
///
/// ```
/// dependencies:
///   # Internationalization support.
///   flutter_localizations:
///     sdk: flutter
///   intl: any # Use the pinned version from flutter_localizations
///
///   # rest of dependencies
/// ```
///
/// ## iOS Applications
///
/// iOS applications define key application metadata, including supported
/// locales, in an Info.plist file that is built into the application bundle.
/// To configure the locales supported by your app, you’ll need to edit this
/// file.
///
/// First, open your project’s ios/Runner.xcworkspace Xcode workspace file.
/// Then, in the Project Navigator, open the Info.plist file under the Runner
/// project’s Runner folder.
///
/// Next, select the Information Property List item, select Add Item from the
/// Editor menu, then select Localizations from the pop-up menu.
///
/// Select and expand the newly-created Localizations item then, for each
/// locale your application supports, add a new item and select the locale
/// you wish to add from the pop-up menu in the Value field. This list should
/// be consistent with the languages listed in the AppLocalizations.supportedLocales
/// property.
abstract class AppLocalizations {
  AppLocalizations(String locale) : localeName = intl.Intl.canonicalizedLocale(locale.toString());

  final String localeName;

  static AppLocalizations? of(BuildContext context) {
    return Localizations.of<AppLocalizations>(context, AppLocalizations);
  }

  static const LocalizationsDelegate<AppLocalizations> delegate = _AppLocalizationsDelegate();

  /// A list of this localizations delegate along with the default localizations
  /// delegates.
  ///
  /// Returns a list of localizations delegates containing this delegate along with
  /// GlobalMaterialLocalizations.delegate, GlobalCupertinoLocalizations.delegate,
  /// and GlobalWidgetsLocalizations.delegate.
  ///
  /// Additional delegates can be added by appending to this list in
  /// MaterialApp. This list does not have to be used at all if a custom list
  /// of delegates is preferred or required.
  static const List<LocalizationsDelegate<dynamic>> localizationsDelegates = <LocalizationsDelegate<dynamic>>[
    delegate,
    GlobalMaterialLocalizations.delegate,
    GlobalCupertinoLocalizations.delegate,
    GlobalWidgetsLocalizations.delegate,
  ];

  /// A list of this localizations delegate's supported locales.
  static const List<Locale> supportedLocales = <Locale>[
    Locale('en'),
    Locale('es'),
    Locale('pt')
  ];

  /// No description provided for @accessData.
  ///
  /// In en, this message translates to:
  /// **'Access Data'**
  String get accessData;

  /// No description provided for @accontType.
  ///
  /// In en, this message translates to:
  /// **'Accont Type'**
  String get accontType;

  /// No description provided for @accountNumber.
  ///
  /// In en, this message translates to:
  /// **'Account Number'**
  String get accountNumber;

  /// No description provided for @addAPhoto.
  ///
  /// In en, this message translates to:
  /// **'Add a photo'**
  String get addAPhoto;

  /// No description provided for @addressData.
  ///
  /// In en, this message translates to:
  /// **'Address Data'**
  String get addressData;

  /// No description provided for @backButton.
  ///
  /// In en, this message translates to:
  /// **'Back'**
  String get backButton;

  /// No description provided for @balanceAvailable.
  ///
  /// In en, this message translates to:
  /// **'Balance Available'**
  String get balanceAvailable;

  /// No description provided for @bankBranch.
  ///
  /// In en, this message translates to:
  /// **'Bank Branch'**
  String get bankBranch;

  /// No description provided for @bankName.
  ///
  /// In en, this message translates to:
  /// **'Bank Name'**
  String get bankName;

  /// No description provided for @birthDate.
  ///
  /// In en, this message translates to:
  /// **'Birth Date '**
  String get birthDate;

  /// No description provided for @cancelButton.
  ///
  /// In en, this message translates to:
  /// **'Cancel'**
  String get cancelButton;

  /// No description provided for @cardDataInformation.
  ///
  /// In en, this message translates to:
  /// **'You can change the data to receive later in the app\'s Settings.'**
  String get cardDataInformation;

  /// No description provided for @cardNumber.
  ///
  /// In en, this message translates to:
  /// **'Card Number'**
  String get cardNumber;

  /// No description provided for @changeReceiptData.
  ///
  /// In en, this message translates to:
  /// **'You can change the data to receive later in the app\'s Settings.'**
  String get changeReceiptData;

  /// No description provided for @clientLabel.
  ///
  /// In en, this message translates to:
  /// **'Client'**
  String get clientLabel;

  /// No description provided for @clientText.
  ///
  /// In en, this message translates to:
  /// **'I have a business and I\'m looking for delivery guys'**
  String get clientText;

  /// No description provided for @columnChart.
  ///
  /// In en, this message translates to:
  /// **'Column Chart'**
  String get columnChart;

  /// No description provided for @commercialName.
  ///
  /// In en, this message translates to:
  /// **'Commercial Name'**
  String get commercialName;

  /// No description provided for @complement.
  ///
  /// In en, this message translates to:
  /// **'Complement'**
  String get complement;

  /// No description provided for @confirmEmail.
  ///
  /// In en, this message translates to:
  /// **'Confirm E-mail'**
  String get confirmEmail;

  /// No description provided for @confirmPassword.
  ///
  /// In en, this message translates to:
  /// **'Confirm Password'**
  String get confirmPassword;

  /// No description provided for @confirmPreviouslyUsedData.
  ///
  /// In en, this message translates to:
  /// **'The beneficiary\'s personal and address data are the same as previously informed.'**
  String get confirmPreviouslyUsedData;

  /// No description provided for @continueButton.
  ///
  /// In en, this message translates to:
  /// **'Continue'**
  String get continueButton;

  /// No description provided for @cpf.
  ///
  /// In en, this message translates to:
  /// **'CPF'**
  String get cpf;

  /// No description provided for @dataForReceipt.
  ///
  /// In en, this message translates to:
  /// **'Data for Receipt'**
  String get dataForReceipt;

  /// No description provided for @deleverymanLabel.
  ///
  /// In en, this message translates to:
  /// **'Deliveryman'**
  String get deleverymanLabel;

  /// No description provided for @deliveriesByTypeTitle.
  ///
  /// In en, this message translates to:
  /// **'Deliveries by Type'**
  String get deliveriesByTypeTitle;

  /// No description provided for @deliveryClothing.
  ///
  /// In en, this message translates to:
  /// **'Clothing'**
  String get deliveryClothing;

  /// No description provided for @deliveryData.
  ///
  /// In en, this message translates to:
  /// **'Delivery Data'**
  String get deliveryData;

  /// No description provided for @deliveryDataMessage.
  ///
  /// In en, this message translates to:
  /// **'Select the main types of delivery you need to carry out. You can change them later in the app\'s Settings'**
  String get deliveryDataMessage;

  /// No description provided for @deliveryDocuments.
  ///
  /// In en, this message translates to:
  /// **'Documents'**
  String get deliveryDocuments;

  /// No description provided for @deliveryFood.
  ///
  /// In en, this message translates to:
  /// **'Food'**
  String get deliveryFood;

  /// No description provided for @deliveryFragileOrder.
  ///
  /// In en, this message translates to:
  /// **'Fragile Order'**
  String get deliveryFragileOrder;

  /// No description provided for @deliveryHeavyOrder.
  ///
  /// In en, this message translates to:
  /// **'Heavy Order'**
  String get deliveryHeavyOrder;

  /// No description provided for @deliveryOther.
  ///
  /// In en, this message translates to:
  /// **'Other'**
  String get deliveryOther;

  /// No description provided for @deliveryType.
  ///
  /// In en, this message translates to:
  /// **'Delivery Type'**
  String get deliveryType;

  /// No description provided for @deliverymanText.
  ///
  /// In en, this message translates to:
  /// **'I have my own vehicle and I want to deliver'**
  String get deliverymanText;

  /// No description provided for @drawerAbout.
  ///
  /// In en, this message translates to:
  /// **'About'**
  String get drawerAbout;

  /// No description provided for @drawerAccountConfigurations.
  ///
  /// In en, this message translates to:
  /// **'Account Configurations'**
  String get drawerAccountConfigurations;

  /// No description provided for @drawerCompleteExtract.
  ///
  /// In en, this message translates to:
  /// **'Complete Extract'**
  String get drawerCompleteExtract;

  /// No description provided for @drawerCompletedTransactions.
  ///
  /// In en, this message translates to:
  /// **'Completed Transactions'**
  String get drawerCompletedTransactions;

  /// No description provided for @drawerDeliveriesInProgress.
  ///
  /// In en, this message translates to:
  /// **'Deliveries in Progress'**
  String get drawerDeliveriesInProgress;

  /// No description provided for @drawerExit.
  ///
  /// In en, this message translates to:
  /// **'Exit'**
  String get drawerExit;

  /// No description provided for @drawerHelpAndSuport.
  ///
  /// In en, this message translates to:
  /// **'Help and Suport'**
  String get drawerHelpAndSuport;

  /// No description provided for @drawerProfile.
  ///
  /// In en, this message translates to:
  /// **'Profile'**
  String get drawerProfile;

  /// No description provided for @email.
  ///
  /// In en, this message translates to:
  /// **'E-mail'**
  String get email;

  /// No description provided for @emailInUseError.
  ///
  /// In en, this message translates to:
  /// **'E-mail in use'**
  String get emailInUseError;

  /// No description provided for @expiryMonth.
  ///
  /// In en, this message translates to:
  /// **'expiry month'**
  String get expiryMonth;

  /// No description provided for @expiryYear.
  ///
  /// In en, this message translates to:
  /// **'Expiry year'**
  String get expiryYear;

  /// No description provided for @forgotPasswordButton.
  ///
  /// In en, this message translates to:
  /// **'Click here'**
  String get forgotPasswordButton;

  /// No description provided for @forgotPasswordMenssage.
  ///
  /// In en, this message translates to:
  /// **'Forgot your password?'**
  String get forgotPasswordMenssage;

  /// No description provided for @fromCamera.
  ///
  /// In en, this message translates to:
  /// **'From Camera'**
  String get fromCamera;

  /// No description provided for @fromGallery.
  ///
  /// In en, this message translates to:
  /// **'From Gallery'**
  String get fromGallery;

  /// No description provided for @fullName.
  ///
  /// In en, this message translates to:
  /// **'Full Name'**
  String get fullName;

  /// No description provided for @goodAfternoon.
  ///
  /// In en, this message translates to:
  /// **'Good Afternoon,'**
  String get goodAfternoon;

  /// The conventional newborn programmer greeting
  ///
  /// In en, this message translates to:
  /// **'Hello World!'**
  String get helloWorld;

  /// No description provided for @home.
  ///
  /// In en, this message translates to:
  /// **'Home'**
  String get home;

  /// No description provided for @homeAddress.
  ///
  /// In en, this message translates to:
  /// **'Home Address'**
  String get homeAddress;

  /// No description provided for @invalidCredentialsError.
  ///
  /// In en, this message translates to:
  /// **'Invalid Credentials'**
  String get invalidCredentialsError;

  /// No description provided for @invalidFieldError.
  ///
  /// In en, this message translates to:
  /// **'Invalid Field'**
  String get invalidFieldError;

  /// No description provided for @latestTransactions.
  ///
  /// In en, this message translates to:
  /// **'Latest Transaction'**
  String get latestTransactions;

  /// No description provided for @licensePlate.
  ///
  /// In en, this message translates to:
  /// **'License Plate'**
  String get licensePlate;

  /// No description provided for @lineChart.
  ///
  /// In en, this message translates to:
  /// **'Line Chart'**
  String get lineChart;

  /// No description provided for @loginButton.
  ///
  /// In en, this message translates to:
  /// **'Login'**
  String get loginButton;

  /// No description provided for @loginMenssage.
  ///
  /// In en, this message translates to:
  /// **'Please login to continue'**
  String get loginMenssage;

  /// No description provided for @map.
  ///
  /// In en, this message translates to:
  /// **'Map'**
  String get map;

  /// No description provided for @maximumDisplayDistance.
  ///
  /// In en, this message translates to:
  /// **'Maximum display distance on the map'**
  String get maximumDisplayDistance;

  /// No description provided for @myDeliveries.
  ///
  /// In en, this message translates to:
  /// **'My Deliveries'**
  String get myDeliveries;

  /// No description provided for @myDeliveriesMessage.
  ///
  /// In en, this message translates to:
  /// **'this week'**
  String get myDeliveriesMessage;

  /// No description provided for @myPanel.
  ///
  /// In en, this message translates to:
  /// **'My Panel'**
  String get myPanel;

  /// No description provided for @myRatings.
  ///
  /// In en, this message translates to:
  /// **'My Ratings'**
  String get myRatings;

  /// No description provided for @neighborhood.
  ///
  /// In en, this message translates to:
  /// **'Neighborhood'**
  String get neighborhood;

  /// No description provided for @newDelivery.
  ///
  /// In en, this message translates to:
  /// **'New Delivery'**
  String get newDelivery;

  /// No description provided for @number.
  ///
  /// In en, this message translates to:
  /// **'Number'**
  String get number;

  /// No description provided for @password.
  ///
  /// In en, this message translates to:
  /// **'Password'**
  String get password;

  /// No description provided for @perfomaceChartButton.
  ///
  /// In en, this message translates to:
  /// **'Perfomace Chart'**
  String get perfomaceChartButton;

  /// No description provided for @perfomaceChartTitle.
  ///
  /// In en, this message translates to:
  /// **'Perfomace Chart'**
  String get perfomaceChartTitle;

  /// No description provided for @personalData.
  ///
  /// In en, this message translates to:
  /// **'Personal Data'**
  String get personalData;

  /// No description provided for @phoneNumber.
  ///
  /// In en, this message translates to:
  /// **'Phone Number'**
  String get phoneNumber;

  /// No description provided for @registerClient.
  ///
  /// In en, this message translates to:
  /// **'Register Client '**
  String get registerClient;

  /// No description provided for @registerDeliveryPerson.
  ///
  /// In en, this message translates to:
  /// **'Register Delivery Person'**
  String get registerDeliveryPerson;

  /// No description provided for @requiredFieldError.
  ///
  /// In en, this message translates to:
  /// **'Required field'**
  String get requiredFieldError;

  /// No description provided for @saveButton.
  ///
  /// In en, this message translates to:
  /// **'Save'**
  String get saveButton;

  /// No description provided for @selectButton.
  ///
  /// In en, this message translates to:
  /// **'Select'**
  String get selectButton;

  /// No description provided for @signUpButton.
  ///
  /// In en, this message translates to:
  /// **'Sign Up'**
  String get signUpButton;

  /// No description provided for @signUpMessage.
  ///
  /// In en, this message translates to:
  /// **'Don\'t have an account?'**
  String get signUpMessage;

  /// No description provided for @signupPopUpLabel.
  ///
  /// In en, this message translates to:
  /// **'How do you want to register?'**
  String get signupPopUpLabel;

  /// No description provided for @spinnerMessage.
  ///
  /// In en, this message translates to:
  /// **'Wait ...'**
  String get spinnerMessage;

  /// No description provided for @state.
  ///
  /// In en, this message translates to:
  /// **'State'**
  String get state;

  /// No description provided for @status.
  ///
  /// In en, this message translates to:
  /// **'Status'**
  String get status;

  /// No description provided for @status_available.
  ///
  /// In en, this message translates to:
  /// **'Available'**
  String get status_available;

  /// No description provided for @status_busy.
  ///
  /// In en, this message translates to:
  /// **'Busy'**
  String get status_busy;

  /// No description provided for @status_unavailable.
  ///
  /// In en, this message translates to:
  /// **'Unavaiable'**
  String get status_unavailable;

  /// No description provided for @termsOfUseReceiptData.
  ///
  /// In en, this message translates to:
  /// **'I agree with the Terms of Use, Privacy Policy and Location Data Use Policy used by the Delivery Express application available here.'**
  String get termsOfUseReceiptData;

  /// No description provided for @tooltipMyLocation.
  ///
  /// In en, this message translates to:
  /// **'My Location'**
  String get tooltipMyLocation;

  /// No description provided for @totalBalance.
  ///
  /// In en, this message translates to:
  /// **'Total Balance'**
  String get totalBalance;

  /// No description provided for @unexpectedError.
  ///
  /// In en, this message translates to:
  /// **'Something wrong happened. Please try again soon'**
  String get unexpectedError;

  /// No description provided for @vehicleBicycle.
  ///
  /// In en, this message translates to:
  /// **'Bicycle'**
  String get vehicleBicycle;

  /// No description provided for @vehicleCar.
  ///
  /// In en, this message translates to:
  /// **'Car'**
  String get vehicleCar;

  /// No description provided for @vehicleColor.
  ///
  /// In en, this message translates to:
  /// **'Vehicle Color'**
  String get vehicleColor;

  /// No description provided for @vehicleData.
  ///
  /// In en, this message translates to:
  /// **'Vehicle Data'**
  String get vehicleData;

  /// No description provided for @vehicleModel.
  ///
  /// In en, this message translates to:
  /// **'Vehicle Model '**
  String get vehicleModel;

  /// No description provided for @vehicleMotorcycle.
  ///
  /// In en, this message translates to:
  /// **'Motorcycle'**
  String get vehicleMotorcycle;

  /// No description provided for @vehicleOther.
  ///
  /// In en, this message translates to:
  /// **'Other'**
  String get vehicleOther;

  /// No description provided for @vehiclePickupTruck.
  ///
  /// In en, this message translates to:
  /// **'Pickup Truck'**
  String get vehiclePickupTruck;

  /// No description provided for @vehicleTruck.
  ///
  /// In en, this message translates to:
  /// **'Truck'**
  String get vehicleTruck;

  /// No description provided for @vehicleType.
  ///
  /// In en, this message translates to:
  /// **'Vehicle Type'**
  String get vehicleType;

  /// No description provided for @visualization.
  ///
  /// In en, this message translates to:
  /// **'Visualization'**
  String get visualization;

  /// No description provided for @weekSummary.
  ///
  /// In en, this message translates to:
  /// **'Week Summary'**
  String get weekSummary;

  /// No description provided for @weeklyDeliveriesTitle.
  ///
  /// In en, this message translates to:
  /// **'Weekly Deliveries'**
  String get weeklyDeliveriesTitle;

  /// No description provided for @welcomeCardMenssage.
  ///
  /// In en, this message translates to:
  /// **'Use our Location Map and find couriers according to your demand'**
  String get welcomeCardMenssage;

  /// No description provided for @welcomeCardTitle.
  ///
  /// In en, this message translates to:
  /// **'Find delivery people in your area!'**
  String get welcomeCardTitle;

  /// No description provided for @wrongDate.
  ///
  /// In en, this message translates to:
  /// **'Wrong Date'**
  String get wrongDate;
}

class _AppLocalizationsDelegate extends LocalizationsDelegate<AppLocalizations> {
  const _AppLocalizationsDelegate();

  @override
  Future<AppLocalizations> load(Locale locale) {
    return SynchronousFuture<AppLocalizations>(lookupAppLocalizations(locale));
  }

  @override
  bool isSupported(Locale locale) => <String>['en', 'es', 'pt'].contains(locale.languageCode);

  @override
  bool shouldReload(_AppLocalizationsDelegate old) => false;
}

AppLocalizations lookupAppLocalizations(Locale locale) {


  // Lookup logic when only language code is specified.
  switch (locale.languageCode) {
    case 'en': return AppLocalizationsEn();
    case 'es': return AppLocalizationsEs();
    case 'pt': return AppLocalizationsPt();
  }

  throw FlutterError(
    'AppLocalizations.delegate failed to load unsupported locale "$locale". This is likely '
    'an issue with the localizations generation tool. Please file an issue '
    'on GitHub with a reproducible sample app and the gen-l10n configuration '
    'that was used.'
  );
}
