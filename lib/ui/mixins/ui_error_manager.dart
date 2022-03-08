import 'package:flutter/material.dart';

import '../components/components.dart';
import '../helpers/helpes.dart';

mixin UiErrorManager {
  void handleMainError(BuildContext context, Stream<UIError> stream) {
    stream.listen((UIError error) {
      showErrorMessage(context, error.desscription);
    });
  }
}
