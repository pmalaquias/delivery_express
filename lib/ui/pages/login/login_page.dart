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
                          const Text(
                            'Encontre entregadores \nna sua região!',
                            style: TextStyle(fontWeight: FontWeight.w800, fontSize: 24),
                            textAlign: TextAlign.center,
                          ),
                          const SizedBox(height: 8),
                          const Text(
                            'Utiliza o nosso Mapa de Localização \ne encontre encontre entregadores de \nacordo com a sua demanda',
                            textAlign: TextAlign.center,
                          ),
                        ],
                      ),
                    ),
                  ),
                  const SizedBox(
                    height: 16,
                  ),
                  const Text(
                    'Efetue login para continuar',
                    textAlign: TextAlign.center,
                  ),
                  TextFormField(
                    decoration: const InputDecoration(
                      hintText: 'E-mail',
                      label: Text('E-mail'),
                    ),
                    keyboardType: TextInputType.emailAddress,
                  ),
                  const SizedBox(height: 8),
                  TextFormField(
                    decoration: InputDecoration(
                      hintText: 'Senha',
                      label: const Text('Senha'),
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
                      const Text('Esqueceu sua senha?'),
                      TextButton(
                        onPressed: () {},
                        child: const Text('Clique aqui'),
                      ),
                    ],
                  ),
                  ElevatedButton(
                    onPressed: () {},
                    child: const Text('LOGIN'),
                    //color: Colors.red,
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      const Text('Não tem uma conta?'),
                      TextButton(
                        onPressed: () {},
                        child: const Text('Registrar'),
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
