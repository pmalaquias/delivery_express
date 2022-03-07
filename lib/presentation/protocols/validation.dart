// ignore_for_file: constant_identifier_names

abstract class Validation {
  ValidationError validate({required String field, required Map input});
}

enum ValidationError {
  REQUIRED_FIELD,
  INVALID_FIELD,
  NO_ERROR,
}
