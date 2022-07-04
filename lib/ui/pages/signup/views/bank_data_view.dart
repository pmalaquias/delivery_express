import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

import '../../../extension/extension.dart';
import '../../../mixins/mixins.dart' show InputMask;
import '../../pages.dart';

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
          Column(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Column(
                children: [
                  Text(
                    context.loc.dataForReceipt,
                    style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
                  ),
                  ListTile(
                    title: Text(
                      context.loc.confirmPreviouslyUsedData,
                      style: const TextStyle(fontSize: 12),
                    ),
                    leading: Switch(
                        //activeColor: AppColors.primaryRed,
                        value: valueSwitch,
                        onChanged: (value) {
                          setState(() {
                            valueSwitch = value;
                          });
                        }),
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
                child: Text(context.loc.backButton.toUpperCase()),
              ),
              ElevatedButton(
                onPressed: () {
                  setState(() {
                    widget.controller.nextPage(
                      duration: const Duration(milliseconds: 400),
                      curve: Curves.easeIn,
                    );
                  });
                  Navigator.pushReplacement(
                    context,
                    MaterialPageRoute(
                      builder: (context) => const HomePage(),
                    ),
                  );
                },
                child: Text(context.loc.continueButton.toUpperCase()),
              ),
            ],
          ),
        ],
      ),
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
                    ListTile(
                      title: Text(
                        context.loc.confirmPreviouslyUsedData,
                        style: const TextStyle(fontSize: 12),
                      ),
                      leading: Switch(
                          //activeColor: AppColors.primaryRed,
                          value: valueSwitch,
                          onChanged: (value) {
                            setState(() {
                              valueSwitch = value;
                            });
                          }),
                    ),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        SvgPicture.asset(
                          'lib/ui/assets/images/svg/mastercard-logo.svg',
                          width: 50,
                        ),
                        SvgPicture.asset(
                          'lib/ui/assets/images/svg/american_express.svg',
                          width: 40,
                        ),
                        SvgPicture.asset(
                          'lib/ui/assets/images/svg/visa.svg',
                          width: 50,
                        ),
                        SvgPicture.asset(
                          'lib/ui/assets/images/svg/hipercard.svg',
                          width: 70,
                        ),
                        SvgPicture.asset(
                          'lib/ui/assets/images/svg/elo.svg',
                          width: 40,
                        ),
                      ],
                    ),
                    TextFormField(
                      decoration: InputDecoration(
                        hintText: '0000 0000 0000 0000',
                        label: Text(context.loc.cardNumber),
                      ),
                      inputFormatters: [cardNumberMaskFormatter],
                    ),
                    const SizedBox(height: 8),
                    Wrap(
                      crossAxisAlignment: WrapCrossAlignment.start,
                      alignment: WrapAlignment.start,
                      //mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        DropdownButton<String>(
                          hint: Text(context.loc.expiryMonth),
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
                        const SizedBox(height: 8),
                        DropdownButton<String>(
                          hint: Text(context.loc.expiryYear),
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
                      ],
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
              TextButton(
                onPressed: () {
                  setState(() {
                    widget.controller.previousPage(
                      duration: const Duration(milliseconds: 400),
                      curve: Curves.easeIn,
                    );
                  });
                },
                child: Text(context.loc.backButton.toUpperCase()),
              ),
              ElevatedButton(
                onPressed: () {
                  setState(() {
                    widget.controller.nextPage(
                      duration: const Duration(milliseconds: 400),
                      curve: Curves.easeIn,
                    );
                  });
                  Navigator.pushReplacement(
                    context,
                    MaterialPageRoute(
                      builder: (context) => const HomeClientPage(),
                    ),
                  );
                },
                child: Text(context.loc.continueButton.toUpperCase()),
              ),
            ],
          ),
        ],
      ),
    );
  }
}

const List<String> mes = [
  '01',
  '02',
  '03',
  '04',
  '05',
  '06',
  '07',
  '08',
  '09',
  '10',
  '11',
  '12',
];

const List<String> ano = [
  '2010',
  '2011',
  '2012',
  '2013',
  '2014',
  '2015',
  '2016',
  '2017',
  '2018',
  '2019',
  '2020',
  '2021',
  '2022',
  '2023',
  '2024',
  '2025',
  '2026',
  '2027',
  '2028',
  '2029',
  '2030',
  '2031',
  '2032',
  '2033',
  '2034',
  '2035',
  '2036',
  '2037',
  '2038',
  '2039',
  '2040',
];
