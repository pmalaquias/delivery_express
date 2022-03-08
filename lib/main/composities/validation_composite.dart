import '../../presentation/protocols/protocols.dart' show Validation, ValidationError;
import '../../validation/protocols/protocols.dart' show FieldValidation;

class ValidationComposite implements Validation {
  final List<FieldValidation> validations;

  ValidationComposite(this.validations);

  @override
  ValidationError validate({required String field, required Map input}) {
    late ValidationError error;

    for (final validation in validations.where((v) => v.field == field)) {
      error = validation.validate(input);

      return error;
    }
    return error;
  }
}
