import 'package:flutter/material.dart';

import '../../../../l10n/strings/app_localizations.dart';

class AccessDataView extends StatefulWidget {
  final PageController controller;

  const AccessDataView({Key? key, required this.controller}) : super(key: key);

  @override
  State<AccessDataView> createState() => _AccessDataViewState();
}

class _AccessDataViewState extends State<AccessDataView> {
  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Container(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            SizedBox(
              height: MediaQuery.of(context).size.height * 0.8,
              child: Column(
                children: [
                  Text(
                    AppLocalizations.of(context)!.accessData,
                    style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
                  ),
                  const SizedBox(height: 16),
                  TextFormField(
                    //controller: _emailTextController,
                    decoration: InputDecoration(
                      hintText: AppLocalizations.of(context)!.email,
                      label: Text(AppLocalizations.of(context)!.email),
                    ),
                    keyboardType: TextInputType.emailAddress,
                  ),
                  const SizedBox(height: 8),
                  TextFormField(
                    //controller: _emailTextController,
                    decoration: InputDecoration(
                      hintText: AppLocalizations.of(context)!.confirmEmail,
                      label: Text(AppLocalizations.of(context)!.confirmEmail),
                    ),
                    keyboardType: TextInputType.emailAddress,
                  ),
                  const SizedBox(height: 8),
                  TextFormField(
                    //controller: _emailTextController,
                    decoration: InputDecoration(
                      hintText: AppLocalizations.of(context)!.password,
                      label: Text(AppLocalizations.of(context)!.password),
                    ),
                    obscureText: true,
                  ),
                  const SizedBox(height: 8),
                  TextFormField(
                    //controller: _emailTextController,
                    decoration: InputDecoration(
                      hintText: AppLocalizations.of(context)!.confirmPassword,
                      label: Text(AppLocalizations.of(context)!.confirmPassword),
                    ),
                    obscureText: true,
                  ),
                  const SizedBox(height: 32),
                ],
              ),
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                TextButton(
                  onPressed: () {
                    setState(() {
                      widget.controller.previousPage(
                        duration: const Duration(milliseconds: 400),
                        curve: Curves.easeIn,
                      );
                    });
                  },
                  child: Text(AppLocalizations.of(context)!.backButton.toUpperCase()),
                ),
                ElevatedButton(
                  onPressed: () {
                    setState(() {
                      widget.controller.nextPage(
                        duration: const Duration(milliseconds: 400),
                        curve: Curves.easeIn,
                      );
                    });
                  },
                  child: Text(AppLocalizations.of(context)!.continueButton.toUpperCase()),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
