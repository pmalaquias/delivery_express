import 'package:flutter/material.dart';

import '../../../l10n/strings/app_localizations.dart';
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
        title: Text(AppLocalizations.of(context)!.registerClient),
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
                  BankDataClientView(controller: controller),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
