import 'package:flutter/material.dart';

import '../../../extension/extension.dart';

class ButtonContinue extends StatelessWidget {
  final Function() function;

  const ButtonContinue({
    Key? key,
    required this.function,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
      onPressed: () => function(),
      child: Text(context.loc.continueButton.toUpperCase()),
    );
  }
}

class ButtonContinuePushReplacement extends StatelessWidget {
  final Function(BuildContext context) function;

  const ButtonContinuePushReplacement({
    Key? key,
    required this.function,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
      onPressed: () => function(context),
      child: Text(context.loc.continueButton.toUpperCase()),
    );
  }
}
