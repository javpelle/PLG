main {
	decVar: {
		int b;
		int a;
	}
	a = 888;
	if (true) {
		decVar: {
			int a;
		}
		a = 999;
		b = a;
	}
}