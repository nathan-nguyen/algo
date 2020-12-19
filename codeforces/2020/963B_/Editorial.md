# Destruction of a Tree

if n is even -> total number of edges are odd -> NO

if n is odd

(*) dfs(Node node) {
	if (Node == null) return;

	for each child: node.child -> dfs(child)

	if node.degree is even -> delete (print) using bfs {

		node -> node's children -> node's grand chilren -> ....

		update node's parent

	}
}

