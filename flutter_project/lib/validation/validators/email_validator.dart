import 'package:equatable/equatable.dart';

import '../../presentation/protocols/validation.dart' show ValidationError;
import '../protocols/protocols.dart' show FieldValidation;

class EmailValidator extends Equatable implements FieldValidation {
  @override
  final String field;

  const EmailValidator({required this.field});

  @override
  ValidationError validate(Map input) {
    final regex = RegExp(r"^[a-zA-Z0-9.a-zA-Z0-9.!#$%&'*+-/=?^_`{|}~]+@[a-zA-Z0-9]+\.[a-zA-Z]+");
    final isValid = input[field].isNotEmpty != true || regex.hasMatch(input[field]);
    return isValid ? ValidationError.NO_ERROR : ValidationError.INVALID_FIELD;
  }

  @override
  List get props => [field];
}
