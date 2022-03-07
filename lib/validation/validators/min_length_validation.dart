import 'package:equatable/equatable.dart';

import '../../presentation/protocols/protocols.dart' show ValidationError;
import '../protocols/field_validation.dart' show FieldValidation;

class MinLengthValidation extends Equatable implements FieldValidation {
  @override
  final String field;
  final int size;

  const MinLengthValidation({required this.field, required this.size});

  @override
  List get props => [field, size];

  @override
  ValidationError validate(Map input) {
    return input[field].length >= size ? ValidationError.NO_ERROR : ValidationError.INVALID_FIELD;
  }
}
