const int BASE = 2;
main {
	decVar: {
		int[11] b;
		int i;
	}
	b[0] = 1;
	i = 1;
	while (i <= 10) {
		b[i] = b[i - 1] * BASE;
		i = i + 1;
	}
}