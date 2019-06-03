package neurology.app.miscellaneous;

import java.io.File;
import java.io.IOException;
import java.util.List;

import neurology.app.model.DiagnosisModel;
import unbbayes.io.BaseIO;
import unbbayes.io.NetIO;
import unbbayes.io.exception.LoadException;
import unbbayes.prs.Node;
import unbbayes.prs.bn.JunctionTreeAlgorithm;
import unbbayes.prs.bn.ProbabilisticNetwork;
import unbbayes.prs.bn.ProbabilisticNode;
import unbbayes.util.extension.bn.inference.IInferenceAlgorithm;

public class BayesController {

//	private String[] bajesFajlovi = { "alcohol_abuse_bayes", "anxiety_bayes", "chronic_back_pain_bayes",
//									"chronic_sinusitis", "concussion_bayes", "dementia_bayes", "depression_bayes", 
//									"epilepsy_bayes", "lumbago_bayes", "migraine_bayes", "parkinson_disease_bayes", 
//									"stroke_bayes" };
	
	public DiagnosisModel CreateBayesNet(String bajesFileName) throws LoadException, IOException {
			ProbabilisticNetwork net = new ProbabilisticNetwork("bayesNet");
			
			BaseIO io = new NetIO();
			net = (ProbabilisticNetwork)io.load(new File(bajesFileName));
			
			//compiling
			IInferenceAlgorithm algorithm = new JunctionTreeAlgorithm();
			algorithm.setNetwork(net);
			algorithm.run();
			
			// states overview
			List<Node> nodeList = net.getNodes();
			for (Node node: nodeList) {
				System.out.println(node.getName());
				for (int i = 0; i < node.getStatesSize(); i++) {
					System.out.println(node.getStateAt(i) + ": " + ((ProbabilisticNode)node).getMarginalAt(i));
				}
			}
			
			//provera da li uopste ima simptoma u trenutno ucitanoj mrezi, ako nema nastavlja se
			for(Node node : net.getNodes()) {
				if(node.getName().equals("imeNoda")) {
					continue;
				}
			}
			
			// adding an evidence
			// namestaju se simptomi koji ulaze u obzir iz liste simptoma koja je popunjena...
			// mora ici for / foreach petlja...
			for(Node node : net.getNodes()) {
				ProbabilisticNode factNode = (ProbabilisticNode)node;
				if(node.getName().equals("imeNoda")) {
					int stateIndex = 1;
					factNode.addFinding(stateIndex);
				}
			}
			
			// propagation
			try {
	        	net.updateEvidences();
	        } catch (Exception e) {
	        	System.out.println(e.getMessage());               	
	        }
			
			// states overview after propagation
			for (Node node : nodeList) {
				System.out.println(node.getName());
				for (int i = 0; i < node.getStatesSize(); i++) {
					System.out.println(node.getStateAt(i) + ": " + ((ProbabilisticNode)node).getMarginalAt(i));
				}
			}
			
			//setuj sve vrednosti za dijagnozu koje trebaju da se prikazu
			
			DiagnosisModel diagnosis = new DiagnosisModel();
			
			diagnosis.setDiagnosisName(nodeList.get(0).getName());
			diagnosis.setDiagnosisPercentage(((ProbabilisticNode)nodeList.get(0)).getMarginalAt(0));
			diagnosis.setNodeState(nodeList.get(0).getStateAt(0));
			
			return diagnosis;
	}
}
