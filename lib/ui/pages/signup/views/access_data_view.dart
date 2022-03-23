import 'package:flutter/material.dart';

class AccessDataView extends StatefulWidget {
  final PageController controller;

  const AccessDataView({Key? key, required this.controller}) : super(key: key);

  @override
  State<AccessDataView> createState() => _AccessDataViewState();
}

class _AccessDataViewState extends State<AccessDataView> {
  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Column(
          children: [
            Text(
              'Dados de Acesso',
              style: Theme.of(context).textTheme.headline5!.copyWith(fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),
            TextFormField(
              //controller: _emailTextController,
              decoration: const InputDecoration(
                hintText: 'E-mail',
                label: Text('E-mail'),
              ),
              keyboardType: TextInputType.emailAddress,
            ),
            const SizedBox(height: 8),
            TextFormField(
              //controller: _emailTextController,
              decoration: const InputDecoration(
                hintText: 'Confirmar e-mail',
                label: Text('Confirmar e-mail'),
              ),
              keyboardType: TextInputType.emailAddress,
            ),
            const SizedBox(height: 8),
            TextFormField(
              //controller: _emailTextController,
              decoration: const InputDecoration(
                hintText: 'Senha',
                label: Text('Senha'),
              ),
              obscureText: true,
            ),
            const SizedBox(height: 8),
            TextFormField(
              //controller: _emailTextController,
              decoration: const InputDecoration(
                hintText: 'Confirmar senha',
                label: Text('Confirmar senha'),
              ),
              obscureText: true,
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
