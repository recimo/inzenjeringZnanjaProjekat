package neurology.app.miscellaneous;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import neurology.app.model.DiagnosisModel;
import neurology.app.model.Symptom;
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
	
	public DiagnosisModel CreateBayesNet(String bajesFileName, ArrayList<Symptom> symptoms) throws LoadException, IOException {
			ProbabilisticNetwork net = new ProbabilisticNetwork("bayesNet");
			
			BaseIO io = new NetIO();
			String fileName = "data/bajesMreze/" + bajesFileName +".net";
			net = (ProbabilisticNetwork)io.load(new File(fileName));
			
			//compiling
			IInferenceAlgorithm algorithm = new JunctionTreeAlgorithm();
			algorithm.setNetwork(net);
			algorithm.run();
			
			// states overview
			List<Node> nodeList = net.getNodes();
			
			boolean hasAtLeastOne = false;
			for(Node node : nodeList) {
				for(Symptom symptom : symptoms) {
					if(node.getName().equals(symptom.getName())) {
						hasAtLeastOne = true;
						break;	
					}
				}
			}
			
			if(!hasAtLeastOne) {
				DiagnosisModel dm = new DiagnosisModel();
				dm.setDiagnosisName("Empty");
				dm.setDiagnosisPercentage(0);
				return dm;
			}
			
//			for (Node node: nodeList) {
//				System.out.println(node.getName());
//				for (int i = 0; i < node.getStatesSize(); i++) {
//					System.out.println(node.getStateAt(i) + ": " + ((ProbabilisticNode)node).getMarginalAt(i));
//				}
//			}
			
			// adding an evidence
			// namestaju se simptomi koji ulaze u obzir iz liste simptoma koja je popunjena...
			// mora ici for / foreach petlja...
			for(Node node : net.getNodes()) {
				
				boolean found = false;
				for(Symptom s : symptoms) {
					if(node.getName().equals(s.getName())) {
						found = true;
						break;
					}
				}
				
				ProbabilisticNode factNode = (ProbabilisticNode)node;
				//if(node.getName().equals("imeNoda")) {
				if(!found) {
					int stateIndex = 0;
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
			
			System.out.println("OVAJ SALJEM: " + nodeList.get(0).getName());
			
			//setuj sve vrednosti za dijagnozu koje trebaju da se prikazu
			
			DiagnosisModel diagnosis = new DiagnosisModel();
			
			diagnosis.setDiagnosisName(nodeList.get(0).getName());
			diagnosis.setDiagnosisPercentage(((ProbabilisticNode)nodeList.get(0)).getMarginalAt(0));
			
			return diagnosis;
	}
}
