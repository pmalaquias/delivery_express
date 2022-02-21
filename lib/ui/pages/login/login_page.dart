import 'package:delivery_express/l10n/strings/app_localizations.dart';
import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

import '../../theme/theme.dart' show AppColors;
import '../../utils/images.dart';

class LoginPage extends StatefulWidget {
  const LoginPage({Key? key}) : super(key: key);

  @override
  State<LoginPage> createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  @override
  Widget build(BuildContext context) {
    Icon visibilityIcon = const Icon(Icons.visibility);
    bool visibilityPassword = true;

    return Scaffold(
      body: SafeArea(
        child: SingleChildScrollView(
          child: Center(
            child: Padding(
              padding: const EdgeInsets.all(16.0),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                crossAxisAlignment: CrossAxisAlignment.stretch,
                children: [
                  Image.asset(Images.logoApp),
                  Card(
                    shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(16)),
                    elevation: 8,
                    margin: const EdgeInsets.all(8),
                    child: Padding(
                      padding: const EdgeInsets.all(24.0),
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          SvgPicture.asset(Images.mapEg),
                          const SizedBox(height: 8),
                          Text(
                            AppLocalizations.of(context)!.welcomeCardTitle,
                            style: const TextStyle(fontWeight: FontWeight.w800, fontSize: 24),
                            textAlign: TextAlign.center,
                          ),
                          const SizedBox(height: 8),
                          Text(
                            AppLocalizations.of(context)!.welcomeCardMenssage,
                            textAlign: TextAlign.center,
                          ),
                        ],
                      ),
                    ),
                  ),
                  const SizedBox(
                    height: 16,
                  ),
                  Text(
                    AppLocalizations.of(context)!.loginMenssage,
                    textAlign: TextAlign.center,
                  ),
                  TextFormField(
                    decoration: InputDecoration(
                      hintText: AppLocalizations.of(context)!.email,
                      label: Text(AppLocalizations.of(context)!.email),
                    ),
                    keyboardType: TextInputType.emailAddress,
                  ),
                  const SizedBox(height: 8),
                  TextFormField(
                    decoration: InputDecoration(
                      hintText: AppLocalizations.of(context)!.password,
                      label: Text(AppLocalizations.of(context)!.password),
                      suffixIcon: IconButton(
                        focusColor: AppColors.primaryRed,
                        icon: visibilityIcon,
                        onPressed: () {
                          setState(() {
                            visibilityPassword = !visibilityPassword;
                            if (visibilityIcon == const Icon(Icons.visibility)) {
                              visibilityIcon = const Icon(Icons.visibility_off);
                            } else {
                              visibilityIcon = const Icon(Icons.visibility);
                            }
                          });
                        },
                      ),
                    ),
                    obscureText: visibilityPassword,
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.end,
                    children: [
                      Text(AppLocalizations.of(context)!.forgotPasswordMenssage),
                      TextButton(
                        onPressed: () {},
                        child: Text(AppLocalizations.of(context)!.forgotPasswordButton),
                      ),
                    ],
                  ),
                  ElevatedButton(
                    onPressed: () {},
                    child: Text(AppLocalizations.of(context)!.loginButton.toUpperCase()),
                    //color: Colors.red,
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Text(AppLocalizations.of(context)!.signUpMessage),
                      TextButton(
                        onPressed: () {},
                        child: Text(AppLocalizations.of(context)!.signUpButton),
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
