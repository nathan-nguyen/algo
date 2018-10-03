class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int endIndex = wordList.indexOf(endWord);
		if (endIndex == -1) return 0;

		int startIndex = wordList.indexOf(beginWord);
		if (startIndex == -1) {
			startIndex = wordList.size();
			wordList.add(beginWord);
		}

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < wordList.size(); ++i) graph.add(new ArrayList<>());

		for (int i = 1; i < wordList.size(); ++i) {
			for (int j = 0; j < i; ++j) {
				if (isConnected(wordList.get(i), wordList.get(j))) {
					graph.get(i).add(j);
					graph.get(j).add(i);
				}
			}
		}

		Set<Integer> visited = new HashSet<>();
		Set<Integer> queue = new HashSet<>();
		queue.add(startIndex);

		int answer = 0;
		while (queue.size() > 0) {
			Set<Integer> nextQueue = new HashSet<>();
			visited.addAll(queue);
			++answer;
			for (int node: queue) {
				if (node == endIndex) return answer;
				for (int child: graph.get(node)) {
					if (!visited.contains(child)) nextQueue.add(child);
				}
			}
			queue = nextQueue;
		}

		return 0;
	}

	private boolean isConnected(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); ++i) {
			if (s1.charAt(i) != s2.charAt(i)) ++count;
		}
		return count == 1;
	}
}
