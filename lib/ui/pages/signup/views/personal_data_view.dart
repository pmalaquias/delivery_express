import 'package:flutter/material.dart';
import 'package:mask_text_input_formatter/mask_text_input_formatter.dart';

import '../../../theme/theme.dart';

class PersonalDataDeliverymanView extends StatefulWidget {
  final PageController controller;

  const PersonalDataDeliverymanView({Key? key, required this.controller}) : super(key: key);

  @override
  State<PersonalDataDeliverymanView> createState() => _PersonalDataDeliverymanViewState();
}

class _PersonalDataDeliverymanViewState extends State<PersonalDataDeliverymanView> {
  var cpfMaskFormatter = MaskTextInputFormatter(
    mask: '###.###.###-##',
    filter: {"#": RegExp(r'[0-9]')},
    type: MaskAutoCompletionType.lazy,
  );

  var cellPhoneMaskFormatter = MaskTextInputFormatter(
    mask: '(##) # ####-####',
    filter: {"#": RegExp(r'[0-9]')},
    type: MaskAutoCompletionType.lazy,
  );

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Column(
          children: [
            Text(
              'Dados Pessoais',
              style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 32),
            InkWell(
              onTap: () {},
              borderRadius: BorderRadius.circular(50),
              hoverColor: AppColors.seccondRed,
              radius: 150,
              child: const CircleAvatar(
                maxRadius: 60,
                child: Icon(
                  Icons.person_add,
                  color: Colors.white,
                  size: 72,
                ),
                backgroundColor: AppColors.primaryRed,
              ),
              splashColor: AppColors.seccondRed.withOpacity(0.2),
            ),
            const SizedBox(height: 16),
            TextFormField(
              //controller: _emailTextController,
              decoration: const InputDecoration(
                hintText: 'Nome Completo',
                label: Text('Nome Completo'),
              ),
              keyboardType: TextInputType.name,
            ),
            const SizedBox(height: 8),
            TextFormField(
              decoration: const InputDecoration(
                hintText: '15/01/200',
                label: Text('Data de Nascimento'),
              ),
              keyboardType: TextInputType.datetime,
              inputFormatters: [MaskTextInputFormatter(mask: "##/##/####")],
              validator: (String? value) {
                if (value!.isEmpty) {
                  return null;
                }
                final components = value.split("/");
                if (components.length == 3) {
                  final day = int.tryParse(components[0]);
                  final month = int.tryParse(components[1]);
                  final year = int.tryParse(components[2]);
                  if (day != null && month != null && year != null) {
                    final date = DateTime(year, month, day);
                    if (date.year == year && date.month == month && date.day == day) {
                      return null;
                    }
                  }
                }
                return "wrong date";
              },
            ),
            const SizedBox(height: 8),
            TextFormField(
              //controller: _emailTextController,
              decoration: const InputDecoration(
                hintText: '999.999.999-99',
                label: Text('CPF'),
              ),
              keyboardType: TextInputType.name,
              inputFormatters: [cpfMaskFormatter],
            ),
            TextFormField(
              decoration: const InputDecoration(
                hintText: '(00) 0 0000-0000',
                label: Text('Celular'),
              ),
              keyboardType: TextInputType.phone,
              inputFormatters: [cellPhoneMaskFormatter],
            ),
          ],
        ),
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            TextButton(
              onPressed: () {
                if (widget.controller.page == 0) {
                  Navigator.canPop(context);
                }
              },
              child: const Text('CANCELAR'),
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
