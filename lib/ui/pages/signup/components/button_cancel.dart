import 'package:flutter/material.dart';

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
      onPressed: () => function(context),
      child: Text(context.loc.cancelButton.toUpperCase()),
    );
  }
}
