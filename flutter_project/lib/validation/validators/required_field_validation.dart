import 'package:equatable/equatable.dart';

import '../../presentation/protocols/protocols.dart' show ValidationError;
import '../protocols/protocols.dart' show FieldValidation;

class RequiredFieldValidation extends Equatable implements FieldValidation {
  @override
  final String field;

  const RequiredFieldValidation(this.field);

  @override
  List get props => [field];

  @override
  ValidationError validate(Map input) {
    return input[field].isNotEmpty == true ? ValidationError.NO_ERROR : ValidationError.REQUIRED_FIELD;
    //empty string as 'null'
  }
}
