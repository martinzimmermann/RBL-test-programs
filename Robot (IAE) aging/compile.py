# Builds a FMU from a Modelica Model change model_name, mo_file and compile_to
from pymodelica import compile_fmu
# Specify Modelica model and model file (.mo or .mop)
model_name = 'SimulationWithNois'
mo_file = "C:\\Users\\mzimmerm\\Documents\\Modelica\\SimulationWithNois.mo"
# Compile the model and save the return argument, which is the file name of the FMU
my_fmu = compile_fmu(model_name, mo_file, target='cs',  compile_to='C:\\Users\\mzimmerm\\Documents\\Modelica')