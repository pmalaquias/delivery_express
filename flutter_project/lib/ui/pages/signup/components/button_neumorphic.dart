import 'package:delivery_express/ui/theme/app_colors.dart';
import 'package:flutter/material.dart';

class ButtonNeumophic extends StatefulWidget {
  const ButtonNeumophic({Key? key}) : super(key: key);
  @override
  State<ButtonNeumophic> createState() => _ButtonNeumophicState();
}

class _ButtonNeumophicState extends State<ButtonNeumophic> {
  int value = 0;

  Widget buttonNeumophic(String imgPath, String vehicleTypeName, int index) {
    return GestureDetector(
      onTap: () {
        setState(() {
          value = index;
        });
      },
      child: AnimatedContainer(
        duration: const Duration(microseconds: 200),
        height: 200,
        width: 200,
        decoration: BoxDecoration(
          color: Colors.white,
          border: Border.all(
            color: (value != index) ? Colors.black : AppColors.primaryRed,
          ),
          borderRadius: BorderRadius.circular(15),
          boxShadow: (value == index)
              ? [
                  BoxShadow(
                    color: Colors.grey[500]!,
                    offset: const Offset(4, 4),
                    blurRadius: 15,
                    spreadRadius: 1,
                  ),
                  const BoxShadow(
                    color: Colors.white,
                    offset: Offset(-5, -5),
                    blurRadius: 15,
                    spreadRadius: 1,
                  ),
                ]
              : null,
        ),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Image.network(
              imgPath,
              height: 50,
              color: (value != index) ? Colors.black : AppColors.primaryRed,
            ),
            Text(
              vehicleTypeName,
            ),
          ],
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: <Widget>[
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            SizedBox(
              width: 104,
              height: 95,
              child: buttonNeumophic(
                'https://cdn-icons-png.flaticon.com/512/1553/1553980.png',
                'Carro',
                1,
              ),
            ),
            SizedBox(
              width: 104,
              height: 95,
              child: buttonNeumophic(
                'https://cdn-icons-png.flaticon.com/512/517/517503.png',
                'Caminhoneta',
                2,
              ),
            ),
            SizedBox(
              width: 104,
              height: 95,
              child: buttonNeumophic(
                'https://cdn-icons-png.flaticon.com/512/2373/2373197.png',
                'Caminhão',
                3,
              ),
            ),
          ],
        ),
        const SizedBox(height: 16),
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            SizedBox(
              width: 104,
              height: 95,
              child: buttonNeumophic(
                'https://cdn-icons-png.flaticon.com/512/2060/2060516.png',
                'Motocicleta',
                4,
              ),
            ),
            SizedBox(
              width: 104,
              height: 95,
              child: buttonNeumophic(
                'https://cdn-icons-png.flaticon.com/512/2972/2972215.png',
                'Biclcleta',
                5,
              ),
            ),
            SizedBox(
              width: 104,
              height: 95,
              child: buttonNeumophic(
                'https://cdn-icons-png.flaticon.com/512/2053/2053323.png',
                'Outro',
                6,
              ),
            ),
          ],
        ),
      ],
    );
  }
}
