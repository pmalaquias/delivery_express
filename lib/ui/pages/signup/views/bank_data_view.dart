import 'package:flutter/material.dart';

import '../../../theme/theme.dart';

class BankDataView extends StatefulWidget {
  final PageController controller;

  const BankDataView({Key? key, required this.controller}) : super(key: key);

  @override
  State<BankDataView> createState() => _BankDataViewState();
}

class _BankDataViewState extends State<BankDataView> {
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
              ),
              leading: Switch(
                  activeColor: AppColors.primaryRed,
                  value: valueSwitch,
                  onChanged: (value) {
                    setState(() {
                      valueSwitch = value;
                    });
                  }),
            ),
            //TODO: Nome do banco
            // TODO: Tipo de conta
            //TODO: agencia
            //TODO: Número da conta
            const Text(
              'Você poderá alterar os dados para recebimento posteriormente nas Configurações do aplicativo.',
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 16),
            Row(
              children: [
                Checkbox(
                  activeColor: AppColors.primaryRed,
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
