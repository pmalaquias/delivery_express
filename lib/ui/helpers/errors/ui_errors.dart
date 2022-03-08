// ignore_for_file: constant_identifier_names

enum UIError {
  REQUIRED_FIELD,
  INVALID_FIELD,
  UNEXPECTED,
  INVALID_CREDENTIALS,
  EMAIL_IN_USE,
  NO_ERROR,
}

// TODO: translate errors mensages
extension UIErrorExtension on UIError {
  String get desscription {
    switch (this) {
      case UIError.INVALID_CREDENTIALS:
        return 'InvalidCredentials';
      case UIError.REQUIRED_FIELD:
        return 'RequiredField';
      case UIError.INVALID_FIELD:
        return 'InvalidField';
      case UIError.EMAIL_IN_USE:
        return 'EmailInUse';
      default:
        return 'UnexpectedError';
    }
  }
}
