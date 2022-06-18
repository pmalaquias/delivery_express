import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:provider/provider.dart';

import '../../../l10n/strings/app_localizations.dart' show AppLocalizations;
import '../../components/components.dart';
import '../../mixins/mixins.dart';
import '../../utils/images.dart' show Images;
import 'login.dart';

class LoginPage extends StatefulWidget {
  final LoginPresenter presenter;

  const LoginPage({
    Key? key,
    required this.presenter,
  }) : super(key: key);

  @override
  State<LoginPage> createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> with KeyboardManager, LoadingManager, NavigationManager, UiErrorManager {
  final _formKey = GlobalKey<FormState>();

  IconData visibilityIcon = Icons.visibility;
  bool visibilityPassword = true;

  final _emailTextController = TextEditingController();
  final _passwordTextController = TextEditingController();

  Future<FirebaseApp> _initializeFirebase() async {
    FirebaseApp firebaseApp = await Firebase.initializeApp();
    return firebaseApp;
  }

  @override
  void initState() {
    super.initState();

    handleLoading(context, widget.presenter.isLoadingStream);
    handleMainError(context, widget.presenter.mainErrorStream);
    handleNavigation(widget.presenter.navigateToStream, clear: true);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: SingleChildScrollView(
          child: Center(
            child: Padding(
              padding: const EdgeInsets.all(16.0),
              child: FutureBuilder(
                future: _initializeFirebase(),
                builder: ((context, snapshot) {
                  if (snapshot.connectionState == ConnectionState.done) {
                    return Column(
                      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                      crossAxisAlignment: CrossAxisAlignment.stretch,
                      children: [
                        const AppLogo(),
                        Card(
                          color: Colors.white,
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(16),
                          ),
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
                        Provider(
                          create: (_) => widget.presenter,
                          child: Form(
                            key: _formKey,
                            child: Column(
                              children: [
                                EmailField(
                                  presenter: widget.presenter,
                                  emailTextController: _emailTextController,
                                ),
                                const SizedBox(height: 8),
                                PasswordField(
                                  presenter: widget.presenter,
                                  passwordTextController: _passwordTextController,
                                ),
                                const ForgotPasswordButton(),
                                LoginButton(presenter: widget.presenter),
                                SignUpButton(presenter: widget.presenter),
                              ],
                            ),
                          ),
                        ),
                      ],
                    );
                  }
                  return const Center(
                    child: CircularProgressIndicator(),
                  );
                }),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
