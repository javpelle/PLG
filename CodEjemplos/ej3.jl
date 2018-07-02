main {
	decVar: {
		bool[10] b;
		int i;
	}
	i = 0;
	while (i < 10) {
		if (i < 5) {
			decVar: {
				bool a;
			}
			a = true;
			b[i] = a;
		} else {
			b[i]= false;
		}
		i = i + 1;
	}
}