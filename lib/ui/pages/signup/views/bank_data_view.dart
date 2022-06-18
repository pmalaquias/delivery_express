import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:mask_text_input_formatter/mask_text_input_formatter.dart';

class BankDataDeliverymanView extends StatefulWidget {
  final PageController controller;

  const BankDataDeliverymanView({Key? key, required this.controller}) : super(key: key);

  @override
  State<BankDataDeliverymanView> createState() => _BankDataDeliverymanViewState();
}

class _BankDataDeliverymanViewState extends State<BankDataDeliverymanView> {
  bool valueSwitch = false;
  bool valueCheckbox = false;
  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Column(
          children: [
            Text(
              'Dados para recebimento',
              style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
            ),
            ListTile(
              title: const Text(
                'Os dados pessoais e de endereço do beneficiário são os mesmos informados anteriormente.',
                style: TextStyle(fontSize: 12),
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
              decoration: const InputDecoration(
                hintText: 'Nome do Banco',
                label: Text('Nome do Banco'),
              ),
            ),
            TextFormField(
              decoration: const InputDecoration(
                hintText: 'Tipo de Conta',
                label: Text('Tipo de Conta'),
              ),
            ),
            TextFormField(
              decoration: const InputDecoration(
                hintText: 'Agência',
                label: Text('Agência'),
              ),
            ),
            TextFormField(
              decoration: const InputDecoration(
                hintText: 'Número da Conta',
                label: Text('Número da Conta'),
              ),
            ),
            const SizedBox(height: 8),
            const Text(
              'Você poderá alterar os dados para recebimento posteriormente nas Configurações do aplicativo.',
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 16),
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
                const Expanded(
                  child: Text(
                    'Concordo com os Termos de Uso, Política de Privacidade e Política do Uso de Dados de localização utilizados pelo aplicativo Delivery Express disponíveis aqui.',
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
              child: const Text('VOLTAR'),
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
              child: const Text('CONTINUAR'),
            ),
          ],
        ),
      ],
    );
  }
}

class BackDataClientView extends StatefulWidget {
  final PageController controller;

  const BackDataClientView({
    Key? key,
    required this.controller,
  }) : super(key: key);

  @override
  State<BackDataClientView> createState() => _BackDataClientViewState();
}

class _BackDataClientViewState extends State<BackDataClientView> {
  bool valueSwitch = false;
  bool valueCheckbox = false;
  String? dropdownValueAno;
  String? dropdownValueMes;

  MaskTextInputFormatter cardNumberMaskFormatter = MaskTextInputFormatter(
    mask: '#### #### #### ####',
    filter: {"#": RegExp(r'[0-9]')},
    type: MaskAutoCompletionType.lazy,
  );

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Expanded(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Column(
                children: [
                  Text(
                    'Dados para recebimento',
                    style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
                  ),
                  ListTile(
                    title: const Text(
                      'Os dados pessoais e de endereço do beneficiário são os mesmos informados anteriormente.',
                      style: TextStyle(fontSize: 12),
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
                    decoration: const InputDecoration(
                      hintText: '0000 0000 0000 0000',
                      label: Text('Número do Cartão'),
                    ),
                    inputFormatters: [cardNumberMaskFormatter],
                  ),
                  const SizedBox(height: 8),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      DropdownButton<String>(
                        hint: const Text('Mês de expiração'),
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
                        hint: const Text('Ano de expiração'),
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
                  const Text(
                    'Você poderá alterar os dados para recebimento posteriormente nas Configurações do aplicativo.',
                    textAlign: TextAlign.center,
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
                      const Expanded(
                        child: Text(
                          'Concordo com os Termos de Uso, Política de Privacidade e Política do Uso de Dados de localização utilizados pelo aplicativo Delivery Express disponíveis aqui.',
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
              child: const Text('VOLTAR'),
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
              child: const Text('CONTINUAR'),
            ),
          ],
        ),
      ],
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
