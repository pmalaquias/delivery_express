import 'package:flutter/material.dart';
import 'package:flutter_config/flutter_config.dart';

import 'main/app.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await FlutterConfig.loadEnvVariables();

  FlutterConfig.get('GOOGLE_MAPS_API_KEY');

  runApp(const DeliveryExpressApp());
}
