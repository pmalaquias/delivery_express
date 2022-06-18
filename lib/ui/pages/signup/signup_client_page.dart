import 'package:flutter/material.dart';

import 'views/views.dart';

class SignUpClientPage extends StatefulWidget {
  const SignUpClientPage({Key? key}) : super(key: key);

  @override
  State<SignUpClientPage> createState() => _SignUpClientPageState();
}

class _SignUpClientPageState extends State<SignUpClientPage> {
  @override
  Widget build(BuildContext context) {
    PageController controller = PageController(
      initialPage: 0,
    );
    return Scaffold(
      resizeToAvoidBottomInset: false,
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
                children: [
                  PersonalDataClientView(controller: controller),
                  AccessDataView(controller: controller),
                  AddressDataView(controller: controller),
                  DeliveyDataView(controller: controller),
                  BackDataClientView(controller: controller),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
