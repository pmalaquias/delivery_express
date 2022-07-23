import 'package:flutter/material.dart';
import 'package:flutter_switch/flutter_switch.dart';
import 'package:get/get.dart';

import '../../../extension/extension.dart';
import '../../../mixins/mixins.dart' show InputMask;
import '../../../mocks/mocks.dart';
import '../components/components.dart';

class BankDataDeliverymanView extends StatefulWidget {
  final PageController controller;

  const BankDataDeliverymanView({Key? key, required this.controller}) : super(key: key);

  @override
  State<BankDataDeliverymanView> createState() => _BankDataDeliverymanViewState();
}

class _BankDataDeliverymanViewState extends State<BankDataDeliverymanView> with InputMask {
  bool valueSwitch = false;
  bool valueCheckbox = false;
  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          SizedBox(
            height: MediaQuery.of(context).size.height * 0.8,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Column(
                  children: [
                    Text(
                      context.loc.dataForReceipt,
                      style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
                    ),
                    const SizedBox(height: 8),
                    Row(
                      children: [
                        FlutterSwitch(
                          activeColor: Theme.of(context).primaryColor,
                          activeToggleColor: const Color(0xFFFFFFFF),
                          inactiveToggleColor: const Color(0xFF857371),
                          toggleSize: 24,
                          inactiveColor: const Color(0xFFF5DDDA),
                          inactiveSwitchBorder: Border.all(color: const Color(0xFF857371), width: 2.0),
                          activeIcon: const Icon(Icons.check_rounded, color: Color(0xFF410002)),
                          height: 32,
                          width: 52,
                          borderRadius: 30.0,
                          value: valueSwitch,
                          onToggle: (val) {
                            setState(() {
                              valueSwitch = val;
                            });
                          },
                        ),
                        const SizedBox(width: 16),
                        Expanded(
                          child: Text(
                            context.loc.confirmPreviouslyUsedData,
                            style: const TextStyle(fontSize: 12),
                          ),
                        ),
                      ],
                    ),
                    TextFormField(
                      decoration: InputDecoration(
                        hintText: context.loc.bankName,
                        label: Text(context.loc.bankName),
                      ),
                    ),
                    TextFormField(
                      decoration: InputDecoration(
                        hintText: context.loc.accountType,
                        label: Text(context.loc.accountType),
                      ),
                    ),
                    TextFormField(
                      decoration: InputDecoration(
                        hintText: context.loc.bankBranch,
                        label: Text(context.loc.bankBranch),
                      ),
                      inputFormatters: [bankBranchMaskFormatter],
                    ),
                    TextFormField(
                      decoration: InputDecoration(
                        hintText: context.loc.accountNumber,
                        label: Text(context.loc.accountNumber),
                      ),
                      inputFormatters: [accountNumberMaskFormatter],
                    ),
                    const SizedBox(height: 8),
                    Text(
                      context.loc.changeReceiptData,
                      textAlign: TextAlign.center,
                    ),
                    const SizedBox(height: 16),
                  ],
                ),
                Row(
                  children: [
                    Checkbox(
                      value: valueCheckbox,
                      onChanged: (bool? value) {
                        setState(() {
                          valueCheckbox = value!;
                        });
                      },
                    ),
                    Expanded(
                      child: Text(
                        context.loc.termsOfUseReceiptData,
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              ButtonBack(function: pageControllerBack),
              ElevatedButton(
                onPressed: () {
                  setState(() {
                    pageControllerContinue();
                  });
                  Get.offAllNamed('/home/deliveryMan');
                },
                child: Text(context.loc.continueButton.toUpperCase()),
              ),
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

class BankDataClientView extends StatefulWidget {
  final PageController controller;

  const BankDataClientView({
    Key? key,
    required this.controller,
  }) : super(key: key);

  @override
  State<BankDataClientView> createState() => _BankDataClientViewState();
}

class _BankDataClientViewState extends State<BankDataClientView> with InputMask {
  bool valueSwitch = false;
  bool valueCheckbox = false;
  String? dropdownValueAno;
  String? dropdownValueMes;

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          SizedBox(
            height: MediaQuery.of(context).size.height * 0.8,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Column(
                  children: [
                    Text(
                      context.loc.dataForReceipt,
                      style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
                    ),
                    const SizedBox(height: 16),
                    Row(
                      children: [
                        FlutterSwitch(
                          activeColor: Theme.of(context).primaryColor,
                          activeToggleColor: const Color(0xFFFFFFFF),
                          inactiveToggleColor: const Color(0xFF857371),
                          toggleSize: 24,
                          inactiveColor: const Color(0xFFF5DDDA),
                          inactiveSwitchBorder: Border.all(color: const Color(0xFF857371), width: 2.0),
                          activeIcon: const Icon(Icons.check_rounded, color: Color(0xFF410002)),
                          height: 32,
                          width: 52,
                          borderRadius: 30.0,
                          value: valueSwitch,
                          onToggle: (val) {
                            setState(() {
                              valueSwitch = val;
                            });
                          },
                        ),
                        const SizedBox(width: 16),
                        Expanded(
                          child: Text(
                            context.loc.confirmPreviouslyUsedData,
                            style: const TextStyle(fontSize: 12),
                          ),
                        ),
                      ],
                    ),
                    const SizedBox(height: 16),
                    const CustomRadioButton(),
                    TextFormField(
                      decoration: InputDecoration(
                        hintText: '0000 0000 0000 0000',
                        label: Text(context.loc.cardNumber),
                      ),
                      inputFormatters: [cardNumberMaskFormatter],
                    ),
                    const SizedBox(height: 8),
                    SingleChildScrollView(
                      scrollDirection: Axis.horizontal,
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          SizedBox(
                            width: MediaQuery.of(context).size.width / 2.0,
                            child: DropdownButton<String>(
                              alignment: AlignmentDirectional.centerEnd,
                              hint: Text(context.loc.expiryMonth),
                              isExpanded: true,
                              value: dropdownValueMes,
                              elevation: 16,
                              onChanged: (String? newValue) {
                                setState(() {
                                  dropdownValueMes = newValue as String;
                                });
                              },
                              items: mes.map<DropdownMenuItem<String>>((String value) {
                                return DropdownMenuItem<String>(
                                  value: value,
                                  child: Text(value),
                                );
                              }).toList(),
                            ),
                          ),
                          const SizedBox(width: 8),
                          SizedBox(
                            width: MediaQuery.of(context).size.width / 2.0,
                            child: DropdownButton<String>(
                              hint: Text(context.loc.expiryYear),
                              isExpanded: true,
                              value: dropdownValueAno,
                              elevation: 16,
                              onChanged: (String? newValue) {
                                setState(() {
                                  dropdownValueAno = newValue as String;
                                });
                              },
                              items: ano.map<DropdownMenuItem<String>>((String value) {
                                return DropdownMenuItem<String>(
                                  value: value,
                                  child: Text(value),
                                );
                              }).toList(),
                            ),
                          ),
                        ],
                      ),
                    ),
                    const SizedBox(height: 8),
                    Text(
                      context.loc.cardDataInformation,
                      textAlign: TextAlign.center,
                      style: const TextStyle(fontSize: 12),
                    ),
                    const SizedBox(height: 16),
                  ],
                ),
                Column(
                  children: [
                    Row(
                      children: [
                        Checkbox(
                          value: valueCheckbox,
                          onChanged: (bool? value) {
                            setState(() {
                              valueCheckbox = value!;
                            });
                          },
                        ),
                        Expanded(
                          child: Text(
                            context.loc.termsOfUseReceiptData,
                          ),
                        ),
                      ],
                    ),
                    const SizedBox(height: 16),
                  ],
                ),
              ],
            ),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              ButtonBack(function: pageControllerBack),
              ButtonContinuePushReplacement(function: pageControllerContinue),
            ],
          ),
        ],
      ),
    );
  }

  void pageControllerContinue(BuildContext context) {
    setState(() {
      widget.controller.nextPage(
        duration: const Duration(milliseconds: 400),
        curve: Curves.easeIn,
      );
    });
    Get.offAllNamed('/home/client');
  }

  void pageControllerBack() {
    widget.controller.previousPage(
      duration: const Duration(milliseconds: 400),
      curve: Curves.easeIn,
    );
  }
}
