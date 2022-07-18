import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

class RadioOptionCustom<T> extends StatelessWidget {
  final T value;
  final T? groupValue;
  final String label;
  final String text;
  final ValueChanged<T?> onChanged;
  final double imgSize;
  final double selectImgSize;
  final Color accentColor;
  final double widthSizeCard;

  const RadioOptionCustom({
    required this.value,
    required this.groupValue,
    required this.label,
    required this.text,
    required this.onChanged,
    this.imgSize = 20,
    this.selectImgSize = 40,
    this.accentColor = Colors.white,
    this.widthSizeCard = 90,
    Key? key,
  }) : super(key: key);

  Widget _buildLabel() {
    final bool isSelected = value == groupValue;

    return SizedBox(
      width: isSelected ? widthSizeCard : 40,
      height: 50,
      child: Card(
        elevation: !isSelected ? 0 : 1.0,
        color: isSelected ? accentColor : Colors.transparent,
        child: Padding(
          padding: const EdgeInsets.all(2.0),
          child: SvgPicture.asset(
            text,
            height: isSelected ? selectImgSize : imgSize,
            color: isSelected ? null : const Color.fromARGB(99, 158, 158, 158),
          ),
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.all(8),
      child: InkWell(
        onTap: () => onChanged(value),
        splashColor: Theme.of(context).primaryColor.withOpacity(0.1),
        child: Padding(
          padding: const EdgeInsets.all(5),
          child: Row(
            children: [
              _buildLabel(),
            ],
          ),
        ),
      ),
    );
  }
}

class RadioOptionTypeCustom<T> extends StatelessWidget {
  final T value;
  final T? groupValue;
  final String label;
  final String text;
  final ValueChanged<T?> onChanged;
  final double imgSize;

  const RadioOptionTypeCustom({
    required this.value,
    required this.groupValue,
    required this.label,
    required this.text,
    required this.onChanged,
    this.imgSize = 35,
    Key? key,
  }) : super(key: key);

  Widget _buildLabel() {
    final bool isSelected = value == groupValue;

    return Card(
      color: isSelected ? const Color(0xFFFFDAD6) : const Color(0xFFF5DDDA),
      child: SizedBox(
        width: 112,
        height: 95,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            SvgPicture.asset(
              text,
              height: isSelected ? 40 : imgSize,
              color: isSelected ? null : const Color(0xFF534341),
            ),
            Text(
              label,
              style: TextStyle(
                color: isSelected ? Colors.black : const Color(0xFF534341),
              ),
            ),
          ],
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: () => onChanged(value),
      splashColor: Theme.of(context).primaryColor.withOpacity(0.1),
      child: Padding(
        padding: EdgeInsets.zero,
        child: Row(
          children: [
            _buildLabel(),
          ],
        ),
      ),
    );
  }
}
