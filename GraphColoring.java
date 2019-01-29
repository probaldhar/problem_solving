package projects;

public class GraphColoring {
	
	private int numOfVertices;
	private int numOfColors;
	private int[] colors;
	private int[][] adjacencyMatrix;
	
	public GraphColoring(int[][] adjacencyMatrix, int numOfColors) {
		this.numOfColors = numOfColors;
		this.adjacencyMatrix = adjacencyMatrix;
		this.numOfVertices = adjacencyMatrix.length;
		this.colors = new int[numOfVertices];
	}
	
	public void solve() {
		
		if ( solveProblem(0) ) {
			showResults();
		} else {
			System.out.println("No Solution.");
		}
	}

	private boolean solveProblem(int nodeIndex) {
		
		if ( nodeIndex == numOfVertices ) {
			return true;
		}
		
		for ( int colorIndex = 1; colorIndex <= numOfColors; colorIndex++ ) {
			
			if ( isColorValid(nodeIndex, colorIndex) ) {
				colors[nodeIndex] = colorIndex;
				
				if ( solveProblem(nodeIndex + 1) ) {
					return true;
				}
				
				// BACKTRACKING !!!
				
			}
			
		}
		
		return false;
	}

	private boolean isColorValid(int nodeIndex, int colorIndex) {
		
		for ( int i = 0; i < numOfVertices; i++ ) {
			
			// check for adjacent nodes & 
			// the colors of the adjacent nodes
			if ( adjacencyMatrix[nodeIndex][i] == 1 && colorIndex == colors[i] ) {
				return false;
			}
			
		}
		
		return true;
	}

	private void showResults() {
		for ( int i = 0; i < numOfVertices; i++ ) {
			System.out.println("Node " + (i+1) + " has color index: " + colors[i]);
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int[][] graphMatrix = new int[][] {
			{0, 1, 0, 1, 0},
			{1, 0, 1, 1, 0},
			{0, 1, 0, 1, 0},
			{1, 1, 1, 0, 1},
			{0, 0, 0, 1, 0}
		};
		
		int numColors = 3;
		
		GraphColoring graphColor = new GraphColoring(graphMatrix, numColors);
		graphColor.solve();
		
	}

}







