import 'package:easy_mask/easy_mask.dart';
import 'package:mask_text_input_formatter/mask_text_input_formatter.dart';

mixin InputMask {
  MaskTextInputFormatter cpfMaskFormatter = MaskTextInputFormatter(
    mask: '###.###.###-##',
    filter: {"#": RegExp(r'[0-9]')},
    type: MaskAutoCompletionType.lazy,
  );

  MaskTextInputFormatter cellPhoneMaskFormatter = MaskTextInputFormatter(
    mask: '(##) # ####-####',
    filter: {"#": RegExp(r'[0-9]')},
    type: MaskAutoCompletionType.lazy,
  );

  MaskTextInputFormatter birthDataMaskFormatter = MaskTextInputFormatter(
    mask: '##/##/####',
    filter: {"#": RegExp(r'[0-9]')},
    type: MaskAutoCompletionType.lazy,
  );

  MaskTextInputFormatter cardNumberMaskFormatter = MaskTextInputFormatter(
    mask: '#### #### #### ####',
    filter: {"#": RegExp(r'[0-9]')},
    type: MaskAutoCompletionType.lazy,
  );

  MaskTextInputFormatter bankBranchMaskFormatter = MaskTextInputFormatter(
    mask: '####',
    filter: {"#": RegExp(r'[0-9]')},
    type: MaskAutoCompletionType.lazy,
  );

  MaskTextInputFormatter accountNumberMaskFormatter = MaskTextInputFormatter(
    mask: '##.######-##',
    filter: {"#": RegExp(r'[0-9]')},
    type: MaskAutoCompletionType.lazy,
  );

  TextInputMask licensePlateMaskFormatter = TextInputMask(
    mask: ['AAA9A99', 'AAA-9999'],
    maxPlaceHolders: 5,
    reverse: false,
  );
}
