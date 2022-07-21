import 'package:flutter/material.dart';

import '../../../extension/extension.dart';
import '../../../mixins/mixins.dart' show InputMask;
import '../../../theme/theme.dart' show AppColors;
import '../components/components.dart' show AddNewImageDialog, ButtonCancel, ButtonContinue;

class PersonalDataDeliverymanView extends StatefulWidget {
  final PageController controller;

  const PersonalDataDeliverymanView({Key? key, required this.controller}) : super(key: key);

  @override
  State<PersonalDataDeliverymanView> createState() => _PersonalDataDeliverymanViewState();
}

class _PersonalDataDeliverymanViewState extends State<PersonalDataDeliverymanView> with InputMask {
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
                  context.loc.personalData,
                  style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
                  textAlign: TextAlign.left,
                ),
                const SizedBox(height: 32),
                InkWell(
                  onTap: () => dialogAddNewImage(context),
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
                    hintText: context.loc.fullName,
                    label: Text(context.loc.fullName),
                  ),
                  keyboardType: TextInputType.name,
                ),
                const SizedBox(height: 8),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: '15/01/2000',
                    label: Text(context.loc.birthDate),
                  ),
                  keyboardType: TextInputType.datetime,
                  inputFormatters: [birthDataMaskFormatter],
                  validator: (String? value) => dateValidator(value, context),
                ),
                const SizedBox(height: 8),
                TextFormField(
                  //controller: _emailTextController,
                  decoration: InputDecoration(
                    hintText: '999.999.999-99',
                    label: Text(context.loc.cpf),
                  ),
                  keyboardType: TextInputType.name,
                  inputFormatters: [cpfMaskFormatter],
                ),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: '(00) 0 0000-0000',
                    label: Text(context.loc.phoneNumber),
                  ),
                  keyboardType: TextInputType.phone,
                  inputFormatters: [cellPhoneMaskFormatter],
                ),
                const SizedBox(height: 32),
              ],
            ),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              ButtonCancel(function: pageControllerCancel),
              ButtonContinue(function: pageControllerContinue),
            ],
          ),
        ],
      ),
    );
  }

  void pageControllerCancel(BuildContext context) {
    Navigator.canPop(context);
  }

  void pageControllerContinue() {
    widget.controller.nextPage(
      duration: const Duration(milliseconds: 400),
      curve: Curves.easeIn,
    );
  }

  String? dateValidator(String? value, BuildContext context) {
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
    return context.loc.wrongDate;
  }

  Future<dynamic> dialogAddNewImage(BuildContext context) {
    return showDialog(
      context: context,
      builder: (BuildContext context) {
        return const AddNewImageDialog();
      },
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
                  context.loc.personalData,
                  style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
                ),
                const SizedBox(height: 32),
                InkWell(
                  onTap: () => dialogAddNewImage(context),
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
                    hintText: context.loc.fullName,
                    label: Text(context.loc.fullName),
                  ),
                  keyboardType: TextInputType.name,
                ),
                const SizedBox(height: 8),
                TextFormField(
                  //controller: _emailTextController,
                  decoration: InputDecoration(
                    hintText: context.loc.commercialName,
                    label: Text(context.loc.commercialName),
                  ),
                  keyboardType: TextInputType.name,
                ),
                const SizedBox(height: 8),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: '15/01/200',
                    label: Text(context.loc.birthDate),
                  ),
                  keyboardType: TextInputType.datetime,
                  inputFormatters: [birthDataMaskFormatter],
                  validator: (String? value) => dateValidator(value, context),
                ),
                const SizedBox(height: 8),
                TextFormField(
                  //controller: _emailTextController,
                  decoration: InputDecoration(
                    hintText: '999.999.999-99',
                    label: Text(context.loc.cpf),
                  ),
                  keyboardType: TextInputType.name,
                  inputFormatters: [cpfMaskFormatter],
                ),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: '(00) 0 0000-0000',
                    label: Text(context.loc.phoneNumber),
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
              ButtonCancel(function: pageControllerCancel),
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

  void pageControllerCancel(BuildContext context) {
    Navigator.canPop(context);
  }

  String? dateValidator(String? value, BuildContext context) {
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
    return context.loc.wrongDate;
  }

  Future<dynamic> dialogAddNewImage(BuildContext context) {
    return showDialog(
      context: context,
      builder: (BuildContext context) {
        return const AddNewImageDialog();
      },
    );
  }
}
