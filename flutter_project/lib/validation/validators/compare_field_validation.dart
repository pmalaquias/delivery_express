import 'package:equatable/equatable.dart';

import '../../presentation/protocols/protocols.dart' show ValidationError;
import '../protocols/protocols.dart' show FieldValidation;

class CompareFieldValidation extends Equatable implements FieldValidation {
  @override
  final String field;
  final String fieldToCompare;

  const CompareFieldValidation({required this.field, required this.fieldToCompare});

  @override
  List get props => [field];

  @override
  ValidationError validate(Map input) =>
      input[field] != null && input[fieldToCompare] != null && input[field] != input[fieldToCompare]
          ? ValidationError.INVALID_FIELD
          : ValidationError.NO_ERROR;
}
