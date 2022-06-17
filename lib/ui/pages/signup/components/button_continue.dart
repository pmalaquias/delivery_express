import 'dart:async';

import 'package:flutter/material.dart';

class ButtonContinue extends StatelessWidget {
  final PageController controller;
  final FutureOr<void> Function() func;
  const ButtonContinue({
    Key? key,
    required this.controller,
    required this.func,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
      onPressed: () async {
        await func();
        controller.nextPage(
          duration: const Duration(milliseconds: 400),
          curve: Curves.easeIn,
        );
      },
      child: const Text('CONTINUAR'),
    );
  }
}
