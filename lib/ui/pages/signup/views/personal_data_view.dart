import 'package:flutter/material.dart';

import '../../../../l10n/strings/app_localizations.dart';
import '../../../mixins/mixins.dart' show InputMask;
import '../../../theme/theme.dart';

class PersonalDataDeliverymanView extends StatefulWidget {
  final PageController controller;

  const PersonalDataDeliverymanView({Key? key, required this.controller}) : super(key: key);

  @override
  State<PersonalDataDeliverymanView> createState() => _PersonalDataDeliverymanViewState();
}

class _PersonalDataDeliverymanViewState extends State<PersonalDataDeliverymanView> with InputMask {
  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: SingleChildScrollView(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            Column(
              children: [
                Text(
                  AppLocalizations.of(context)!.personalData,
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
                  decoration: InputDecoration(
                    hintText: AppLocalizations.of(context)!.fullName,
                    label: Text(AppLocalizations.of(context)!.fullName),
                  ),
                  keyboardType: TextInputType.name,
                ),
                const SizedBox(height: 8),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: '15/01/2000',
                    label: Text(AppLocalizations.of(context)!.birthDate),
                  ),
                  keyboardType: TextInputType.datetime,
                  inputFormatters: [birthDataMaskFormatter],
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
                    return AppLocalizations.of(context)!.wrongDate;
                  },
                ),
                const SizedBox(height: 8),
                TextFormField(
                  //controller: _emailTextController,
                  decoration: InputDecoration(
                    hintText: '999.999.999-99',
                    label: Text(AppLocalizations.of(context)!.cpf),
                  ),
                  keyboardType: TextInputType.name,
                  inputFormatters: [cpfMaskFormatter],
                ),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: '(00) 0 0000-0000',
                    label: Text(AppLocalizations.of(context)!.phoneNumber),
                  ),
                  keyboardType: TextInputType.phone,
                  inputFormatters: [cellPhoneMaskFormatter],
                ),
                const SizedBox(height: 32),
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
                  child: Text(AppLocalizations.of(context)!.cancelButton.toUpperCase()),
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

class PersonalDataClientView extends StatefulWidget {
  final PageController controller;

  const PersonalDataClientView({
    Key? key,
    required this.controller,
  }) : super(key: key);

  @override
  State<PersonalDataClientView> createState() => _PersonalDataClientViewState();
}

class _PersonalDataClientViewState extends State<PersonalDataClientView> with InputMask {
  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          SizedBox(
            height: MediaQuery.of(context).size.height * 0.9,
            child: Column(
              children: [
                Text(
                  AppLocalizations.of(context)!.personalData,
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
                  decoration: InputDecoration(
                    hintText: AppLocalizations.of(context)!.fullName,
                    label: Text(AppLocalizations.of(context)!.fullName),
                  ),
                  keyboardType: TextInputType.name,
                ),
                const SizedBox(height: 8),
                TextFormField(
                  //controller: _emailTextController,
                  decoration: InputDecoration(
                    hintText: AppLocalizations.of(context)!.commercialName,
                    label: Text(AppLocalizations.of(context)!.commercialName),
                  ),
                  keyboardType: TextInputType.name,
                ),
                const SizedBox(height: 8),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: '15/01/200',
                    label: Text(AppLocalizations.of(context)!.birthDate),
                  ),
                  keyboardType: TextInputType.datetime,
                  inputFormatters: [birthDataMaskFormatter],
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
                  decoration: InputDecoration(
                    hintText: '999.999.999-99',
                    label: Text(AppLocalizations.of(context)!.cpf),
                  ),
                  keyboardType: TextInputType.name,
                  inputFormatters: [cpfMaskFormatter],
                ),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: '(00) 0 0000-0000',
                    label: Text(AppLocalizations.of(context)!.phoneNumber),
                  ),
                  keyboardType: TextInputType.phone,
                  inputFormatters: [cellPhoneMaskFormatter],
                ),
              ],
            ),
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
                child: Text(AppLocalizations.of(context)!.cancelButton.toUpperCase()),
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
    );
  }
}
