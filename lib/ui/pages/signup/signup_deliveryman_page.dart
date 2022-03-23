import 'package:flutter/material.dart';

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
        title: const Text('Cadastrar Cliente'),
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
                children: const [
                  //TODO: add PersonalDataView(),
                  //TODO: add AccessDataView(),
                  //TODO: add AddressDataView(),
                  //TODO: add VehicleDataView(),
                  //TODO: add BankDataView(),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
