import 'package:flutter/material.dart';

import '../../extension/extension.dart';
import 'views/views.dart';

class SignUpDeliveryMan extends StatefulWidget {
  const SignUpDeliveryMan({Key? key}) : super(key: key);

  @override
  State<SignUpDeliveryMan> createState() => _SignUpDeliveryManState();
}

class _SignUpDeliveryManState extends State<SignUpDeliveryMan> {
  @override
  Widget build(BuildContext context) {
    PageController controller = PageController(
      initialPage: 0,
    );
    return Scaffold(
      appBar: AppBar(
        title: Text(context.loc.registerDeliveryPerson),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Expanded(
              child: PageView(
                physics: const NeverScrollableScrollPhysics(),
                controller: controller,
                children: [
                  PersonalDataDeliverymanView(controller: controller),
                  AccessDataView(controller: controller),
                  AddressDataView(controller: controller),
                  VehicleDataView(controller: controller),
                  BankDataDeliverymanView(controller: controller),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
