import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../extension/extension.dart';
import 'signup.dart';
import 'views/views.dart';

class SignUpClientPage extends StatefulWidget {
  final SignUpPresenter presenter;

  const SignUpClientPage({
    Key? key,
    required this.presenter,
  }) : super(key: key);

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
        title: Text(context.loc.registerClient),
      ),
      body: Padding(
        padding: const EdgeInsets.only(top: 16, left: 16, right: 16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Expanded(
              child: Provider(
                create: (_) => widget.presenter,
                child: PageView(
                  physics: const NeverScrollableScrollPhysics(),
                  controller: controller,
                  children: [
                    PersonalDataClientView(controller: controller, presenter: widget.presenter),
                    AccessDataView(controller: controller),
                    AddressDataView(controller: controller),
                    DeliveryDataView(controller: controller),
                    BankDataClientView(controller: controller),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
