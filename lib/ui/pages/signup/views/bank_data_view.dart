import 'package:flutter/material.dart';

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
