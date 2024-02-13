import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

import '../utils/utils.dart' show Images;

class AppLogo extends StatelessWidget {
  const AppLogo({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        SvgPicture.asset(
          Images.logoImgSvg,
          width: 100,
          color: const Color(0xFFb71c1c),
        ),
        Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: const [
            Text('DELIVERY'),
            Text(
              'Express',
              style: TextStyle(
                fontFamily: 'QuickExpress',
                fontSize: 24,
              ),
            ),
          ],
        ),
      ],
    );
  }
}
