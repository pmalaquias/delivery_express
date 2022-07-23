import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

class PurchaseInfoTile extends StatelessWidget {
  const PurchaseInfoTile({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        const Divider(),
        Row(
          children: [
            SvgPicture.asset('lib/ui/assets/images/svg/food.svg'),
            const VerticalDivider(),
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: const [
                Text(
                  'Supermecado Nova Europa',
                  style: TextStyle(
                    fontWeight: FontWeight.bold,
                    letterSpacing: .1,
                  ),
                ),
                Text('R\$48,00'),
              ],
            ),
            const VerticalDivider(),
            Expanded(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.end,
                children: const [
                  Text(
                    '26 jan 2020',
                    style: TextStyle(fontSize: 12),
                  ),
                  Text(
                    '10:34',
                    style: TextStyle(fontSize: 12),
                  ),
                ],
              ),
            ),
          ],
        ),
      ],
    );
  }
}
