import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../../../extension/extension.dart';

class ButtonCancel extends StatelessWidget {
  final Function(BuildContext context) function;

  const ButtonCancel({
    Key? key,
    required this.function,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return TextButton(
      onPressed: () => Get.offAndToNamed('/auth'),
      child: Text(context.loc.cancelButton.toUpperCase()),
    );
  }
}
