import '../../presentation/protocols/protocols.dart' show ValidationError;

abstract class FieldValidation {
  String get field;

  ValidationError validate(Map input);
}
