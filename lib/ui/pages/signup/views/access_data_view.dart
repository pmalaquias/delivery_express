import 'package:flutter/material.dart';

import '../../../extension/extension.dart';
import '../components/components.dart';

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
      child: Column(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          SizedBox(
            height: MediaQuery.of(context).size.height * 0.8,
            child: Column(
              children: [
                Text(
                  context.loc.accessData,
                  style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
                ),
                const SizedBox(height: 16),
                TextFormField(
                  //controller: _emailTextController,
                  decoration: InputDecoration(
                    hintText: context.loc.email,
                    label: Text(context.loc.email),
                  ),
                  keyboardType: TextInputType.emailAddress,
                ),
                const SizedBox(height: 8),
                TextFormField(
                  //controller: _emailTextController,
                  decoration: InputDecoration(
                    hintText: context.loc.confirmEmail,
                    label: Text(context.loc.confirmEmail),
                  ),
                  keyboardType: TextInputType.emailAddress,
                ),
                const SizedBox(height: 8),
                TextFormField(
                  //controller: _emailTextController,
                  decoration: InputDecoration(
                    hintText: context.loc.password,
                    label: Text(context.loc.password),
                  ),
                  obscureText: true,
                ),
                const SizedBox(height: 8),
                TextFormField(
                  //controller: _emailTextController,
                  decoration: InputDecoration(
                    hintText: context.loc.confirmPassword,
                    label: Text(context.loc.confirmPassword),
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
              ButtonBack(function: pageControllerBack),
              ButtonContinue(function: pageControllerContinue),
            ],
          ),
        ],
      ),
    );
  }

  void pageControllerContinue() {
    widget.controller.nextPage(
      duration: const Duration(milliseconds: 400),
      curve: Curves.easeIn,
    );
  }

  void pageControllerBack() {
    widget.controller.previousPage(
      duration: const Duration(milliseconds: 400),
      curve: Curves.easeIn,
    );
  }
}
