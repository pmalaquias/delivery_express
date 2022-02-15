import 'package:flutter/material.dart';

import '../ui/pages/pages..dart';

class DeliveryExpressApp extends StatelessWidget {
  const DeliveryExpressApp({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Delivery Express',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      debugShowCheckedModeBanner: false,
      home: const LoginPage(),
    );
  }
}
