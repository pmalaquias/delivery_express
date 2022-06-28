import 'package:flutter/material.dart';

class TotalBalanceTile extends StatelessWidget {
  const TotalBalanceTile({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        const Divider(),
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: const [
            Text(
              'Saldo Total',
              style: TextStyle(
                fontWeight: FontWeight.bold,
              ),
            ),
            Text('R\$ 99,00'),
          ],
        ),
      ],
    );
  }
}
